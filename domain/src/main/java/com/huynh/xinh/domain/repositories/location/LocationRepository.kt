package com.huynh.xinh.domain.repositories.location

import com.huynh.xinh.domain.models.GeoAddress
import com.huynh.xinh.domain.models.Location
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Create by Mr.X on 1/28/19
 */
interface LocationRepository {
    fun getCurrentLocation(): Observable<Location>

    fun reverseGeocodeLocation(location: Location): Single<List<GeoAddress>>

    fun geocodeLocation(userQuery: String): Single<List<GeoAddress>>
}