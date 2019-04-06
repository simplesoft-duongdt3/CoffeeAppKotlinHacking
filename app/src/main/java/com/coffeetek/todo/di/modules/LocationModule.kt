package com.coffeetek.todo.di.modules

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.coffeetek.todo.location.geocode.RxGeoCodeLocation
import com.coffeetek.todo.location.geocode.RxGeoCodeLocationImpl
import com.coffeetek.todo.location.rxfusedlocation.RxFusedLocation
import com.coffeetek.todo.location.rxfusedlocation.RxFusedLocationImpl
import com.coffeetek.todo.location.rxlocationmanager.RxLocationManager
import com.coffeetek.todo.location.rxlocationmanager.RxLocationManagerImpl
import com.coffeetek.todo.location.settinglocaiton.SettingLocationChecker
import com.coffeetek.todo.location.settinglocaiton.SettingLocationCheckerImpl
import com.coffeetek.todo.managners.location.MyLocationManager
import com.coffeetek.todo.managners.location.MyLocationManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Create by Mr.X on 1/29/19
 */
@Module
class LocationModule {
    @Provides
    @Singleton
    fun provideLocationManager(context: Application): LocationManager {
        return context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @Singleton
    fun provideRxLocationManager(locationManager: LocationManager): RxLocationManager {
        return RxLocationManagerImpl(locationManager)
    }

    @Provides
    @Singleton
    fun provideRxLocation(context: Application): RxFusedLocation {
        return RxFusedLocationImpl(context)
    }

    @Provides
    @Singleton
    fun provideGeoCodeLocation(context: Application): RxGeoCodeLocation {
        return RxGeoCodeLocationImpl(context)
    }

    @Provides
    @Singleton
    fun provideSettingLoctionChecker(context: Application): SettingLocationChecker {
        return SettingLocationCheckerImpl(context)
    }

    @Provides
    @Singleton
    fun provideMyLocationManager(): MyLocationManager {
        return MyLocationManagerImpl.instance
    }
}