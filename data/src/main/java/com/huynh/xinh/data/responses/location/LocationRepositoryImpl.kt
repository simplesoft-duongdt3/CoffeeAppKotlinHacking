package com.huynh.xinh.data.responses.location

import android.annotation.SuppressLint
import android.location.LocationManager
import com.coffeetek.todo.location.RxLocation
import com.coffeetek.todo.location.geocode.RxGeoCodeLocation
import com.coffeetek.todo.location.rxlocationmanager.RxLocationManager
import com.huynh.xinh.domain.models.GeoAddress
import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import com.huynh.xinh.domain.repositories.location.LocationRepository
import com.huynh.xinh.domain.repositories.location.LocationTime
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Create by Mr.X on 1/28/19
 */
class LocationRepositoryImpl @Inject constructor(
    private val rxLocationManager: RxLocationManager,
    private val rxLocation: RxLocation,
    private val rxGeoCodeLocation: RxGeoCodeLocation
) : LocationRepository {

    @SuppressLint("MissingPermission")
    override fun getCurrentLocation(): Observable<Location> {
        val param = CurrentLocationParam(LocationManager.NETWORK_PROVIDER, LocationTime(1, TimeUnit.HOURS))
        return Observable.merge(getLocationFromLocationManager(param), getLocationFromGoogleApi(param))
    }

    private fun getLocationFromLocationManager(param: CurrentLocationParam): Observable<Location> {
        return Observable.mergeDelayError(
            rxLocationManager.getCurrentLocation(param).subscribeOn(Schedulers.computation()).toObservable(),
            rxLocationManager.getLastLocation(param).subscribeOn(Schedulers.computation()).toObservable()
        )
    }

    private fun getLocationFromGoogleApi(param: CurrentLocationParam): Observable<Location> {
        return rxLocation.getCurrentLocation(param).toObservable()
    }


    override fun reverseGeocodeLocation(location: Location): Single<List<GeoAddress>> {
        return rxGeoCodeLocation.reverseGeocodeLocation(location, 5).subscribeOn(Schedulers.computation())
    }

    override fun geocodeLocation(userQuery: String): Single<List<GeoAddress>> {
        return rxGeoCodeLocation.geocodeLocation(userQuery, 5).subscribeOn(Schedulers.computation())
    }

}