package com.coffeetek.todo.location.settinglocaiton

import com.google.android.gms.location.LocationRequest
import io.reactivex.Single

interface SettingLocationChecker {
    fun check(locationRequest: LocationRequest): Single<Boolean>
}