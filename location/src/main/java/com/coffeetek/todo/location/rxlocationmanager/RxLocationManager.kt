package com.coffeetek.todo.location.rxlocationmanager

import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import io.reactivex.Maybe
import io.reactivex.Single

interface RxLocationManager {
    fun getCurrentLocation(param: CurrentLocationParam): Single<Location>

    fun getLastLocation(param: CurrentLocationParam): Maybe<Location>
}