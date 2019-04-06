package com.coffeetek.todo.location.rxfusedlocation

import com.google.android.gms.location.LocationRequest
import com.huynh.xinh.domain.models.Location
import io.reactivex.Single

/**
 * Create by Mr.X on 1/29/19
 */
interface RxFusedLocation {
    companion object {
        private const val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private const val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS

        val locationRequest = LocationRequest().apply {
            interval = UPDATE_INTERVAL_IN_MILLISECONDS
            fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    fun getCurrentLocation(): Single<Location>
}