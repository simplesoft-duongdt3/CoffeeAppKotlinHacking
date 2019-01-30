package com.coffeetek.todo.location.googleapi

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.support.annotation.RequiresPermission
import com.coffeetek.todo.location.RxLocation
import com.google.android.gms.location.*
import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import io.reactivex.Single
import javax.inject.Inject


/**
 * Create by Mr.X on 1/29/19
 */
class RxFusedLocationImpl @Inject constructor(val context: Context) : RxLocation {

    companion object {
        private const val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private const val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2
    }

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)
    private val locationRequest: LocationRequest = LocationRequest()

    init {
        locationRequest.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        locationRequest.fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    @SuppressLint("MissingPermission")
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    override fun getCurrentLocation(param: CurrentLocationParam): Single<Location> {
        return Single.create {

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)

                    val location = locationResult.lastLocation
                    it.onSuccess(Location(location.latitude, location.longitude))
                }
            }

            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())

            it.setCancellable { fusedLocationClient.removeLocationUpdates(locationCallback) }
        }
    }

}
