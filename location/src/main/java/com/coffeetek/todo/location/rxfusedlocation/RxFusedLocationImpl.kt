package com.coffeetek.todo.location.rxfusedlocation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.support.annotation.RequiresPermission
import com.coffeetek.todo.location.rxfusedlocation.RxFusedLocation.Companion.locationRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.huynh.xinh.domain.models.Location
import io.reactivex.Single
import javax.inject.Inject

class RxFusedLocationImpl @Inject constructor(private val context: Context) : RxFusedLocation {

    @SuppressLint("MissingPermission")
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    override fun getCurrentLocation(): Single<Location> {
        return getCurrentLocation(context)
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation(context: Context): Single<Location> {
        val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

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
