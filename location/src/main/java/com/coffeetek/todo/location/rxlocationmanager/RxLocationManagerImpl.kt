package com.coffeetek.todo.location.rxlocationmanager

import android.Manifest
import android.annotation.SuppressLint
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import android.support.annotation.RequiresPermission
import com.coffeetek.todo.location.exception.ElderLocationException
import com.coffeetek.todo.location.exception.ProviderDisabledException
import com.coffeetek.todo.location.exception.ProviderHasNoLastLocationException
import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import com.huynh.xinh.domain.repositories.location.LocationTime
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import javax.inject.Inject

class RxLocationManagerImpl @Inject constructor(private val locationManager: LocationManager) : RxLocationManager {

    @SuppressLint("MissingPermission")
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    override fun getLastLocation(param: CurrentLocationParam): Maybe<Location> {
        val provider = param.provider
        val timeOut = param.timeOut

        return Maybe.fromCallable {
            locationManager.getLastKnownLocation(provider)
                    ?: throw ProviderHasNoLastLocationException(provider)
        }
                .onErrorComplete { it is ProviderHasNoLastLocationException }
                .map {
                    if (timeOut != null && !it.isNotOld(timeOut)) {
                        throw ElderLocationException(it)
                    } else {
                        Location(it.latitude, it.longitude)
                    }
                }
    }

    @SuppressLint("MissingPermission")
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    override fun getCurrentLocation(param: CurrentLocationParam): Single<Location> {
        val provider = param.provider
        val timeOut = param.timeOut

        return Single.create(SingleOnSubscribe<Location> {
            if (locationManager.isProviderEnabled(provider)) {

                val locationListener = object : LocationListener {
                    override fun onLocationChanged(location: android.location.Location) {
                        it.onSuccess(Location(location.latitude, location.longitude))
                    }

                    override fun onProviderDisabled(p: String?) {
                        if (provider == p) {
                            it.onError(ProviderDisabledException(provider))
                        }
                    }

                    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {}

                    override fun onProviderEnabled(p: String?) {}
                }

                locationManager.requestSingleUpdate(provider, locationListener, Looper.getMainLooper())

                it.setCancellable { locationManager.removeUpdates(locationListener) }

            } else {
                it.onError(ProviderDisabledException(provider))
            }
        })
                .compose { if (timeOut != null) it.timeout(timeOut.time, timeOut.timeUnit) else it }
    }
}

fun android.location.Location.isNotOld(howOldCanBe: LocationTime): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos < howOldCanBe.timeUnit.toNanos(howOldCanBe.time)
    } else {
        System.currentTimeMillis() - time < howOldCanBe.timeUnit.toMillis(howOldCanBe.time)
    }

}
