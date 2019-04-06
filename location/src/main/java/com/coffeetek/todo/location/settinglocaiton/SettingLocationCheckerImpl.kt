package com.coffeetek.todo.location.settinglocaiton

import android.content.Context
import com.google.android.gms.location.LocationRequest
import io.reactivex.Single

class SettingLocationCheckerImpl(private val context: Context) : SettingLocationChecker {
    override fun check(locationRequest: LocationRequest): Single<Boolean> {
        return Single.create(SettingsFusedLocationSingleOnSubscribe(context, locationRequest))
    }
}