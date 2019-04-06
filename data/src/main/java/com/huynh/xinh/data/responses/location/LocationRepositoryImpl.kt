package com.huynh.xinh.data.responses.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import com.coffeetek.todo.location.exception.LocationSettingsNotSatisfiedException
import com.coffeetek.todo.location.geocode.RxGeoCodeLocation
import com.coffeetek.todo.location.rxfusedlocation.RxFusedLocation
import com.coffeetek.todo.location.rxfusedlocation.RxFusedLocation.Companion.locationRequest
import com.coffeetek.todo.location.rxlocationmanager.RxLocationManager
import com.coffeetek.todo.location.settinglocaiton.SettingLocationChecker
import com.coffeetek.todo.location.settinglocaiton.SettingsFusedLocationSingleOnSubscribe
import com.google.android.gms.location.LocationRequest
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

class LocationRepositoryImpl @Inject constructor(
        private val settingLocationChecker: SettingLocationChecker,
        private val rxLocationManager: RxLocationManager,
        private val rxFusedLocation: RxFusedLocation,
        private val rxGeoCodeLocation: RxGeoCodeLocation
) : LocationRepository {

    @SuppressLint("MissingPermission")
    override fun getCurrentLocation(): Observable<Location> {
        return getUserLocationAndStartDetectCurrentLocation()
    }

    private fun getUserLocationAndStartDetectCurrentLocation(): Observable<Location> {
        return settingLocationChecker.check(locationRequest).toObservable()
                .flatMap {
                    if (it) {
                        startDetectCurrentLocation()
                    } else {
                        throw LocationSettingsNotSatisfiedException()
                    }
                }
    }

    private fun startDetectCurrentLocation(): Observable<Location> {
        return Observable.mergeDelayError(getLocationFromLocationManager(), getFusedLocation())
    }

    private fun checkSettingsLocation(context: Context, locationRequest: LocationRequest): Single<Boolean> {
        return Single.create(
                SettingsFusedLocationSingleOnSubscribe(
                        context,
                        locationRequest
                )
        )
    }

    private fun getLocationFromLocationManager(): Observable<Location> {
        val param = CurrentLocationParam(LocationManager.NETWORK_PROVIDER, LocationTime(1, TimeUnit.HOURS))

        return Observable.mergeDelayError(
                rxLocationManager.getCurrentLocation(param).subscribeOn(Schedulers.io()).toObservable(),
                rxLocationManager.getLastLocation(param).subscribeOn(Schedulers.io()).toObservable()
        )
    }

    private fun getFusedLocation(): Observable<Location> {
        return rxFusedLocation.getCurrentLocation().subscribeOn(Schedulers.io()).toObservable()
    }

    override fun reverseGeocodeLocation(location: Location): Single<List<GeoAddress>> {
        return rxGeoCodeLocation.reverseGeocodeLocation(location, 5).subscribeOn(Schedulers.computation())
    }

    override fun geocodeLocation(userQuery: String): Single<List<GeoAddress>> {
        return rxGeoCodeLocation.geocodeLocation(userQuery, 5).subscribeOn(Schedulers.computation())
    }
}