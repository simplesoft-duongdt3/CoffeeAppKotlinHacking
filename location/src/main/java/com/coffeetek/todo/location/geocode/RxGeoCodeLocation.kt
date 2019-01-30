package com.coffeetek.todo.location.geocode

import com.huynh.xinh.domain.models.GeoAddress
import com.huynh.xinh.domain.models.Location
import io.reactivex.Single

/**
 * Create by Mr.X on 1/30/19
 */
interface RxGeoCodeLocation {
    fun reverseGeocodeLocation(location: Location, maxResult: Int): Single<List<GeoAddress>>

    fun geocodeLocation(userQuery: String, maxResult: Int): Single<List<GeoAddress>>
}