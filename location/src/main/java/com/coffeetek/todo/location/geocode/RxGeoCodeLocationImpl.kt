package com.coffeetek.todo.location.geocode

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.huynh.xinh.domain.models.GeoAddress
import com.huynh.xinh.domain.models.Location
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class RxGeoCodeLocationImpl @Inject constructor(private val context: Context) : RxGeoCodeLocation {
    override fun reverseGeocodeLocation(location: Location, maxResult: Int): Single<List<GeoAddress>> {
        return Single.defer {
            val geoAddresses = createGeocoder().getFromLocation(location.lat, location.lng, maxResult)

            return@defer Single.just(geoAddresses.map { toGeoAddress(it) })
        }
    }

    override fun geocodeLocation(userQuery: String, maxResult: Int): Single<List<GeoAddress>> {
        return Single.defer {
            val geoAddresses = createGeocoder().getFromLocationName(userQuery, maxResult)

            return@defer Single.just(geoAddresses.map { toGeoAddress(it) })
        }
    }

    private fun createGeocoder(): Geocoder {
        return Geocoder(context, Locale.getDefault())
    }

    private fun toGeoAddress(address: Address): GeoAddress {
        val lat = address.latitude
        val lng = address.longitude
        val addressName = address.getAddressLine(0)
        val city = address.locality
        val state = address.adminArea
        val country = address.countryName
        val postalCode = address.postalCode
        val knownName = address.featureName

        return GeoAddress(lat, lng, addressName, city, state, country, postalCode, knownName)
    }
}