package com.coffeetek.todo.location.rxlocationmanager

import com.coffeetek.todo.location.RxLocation
import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import io.reactivex.Maybe

/**
 * Create by Mr.X on 1/28/19
 */
interface RxLocationManager : RxLocation {
    fun getLastLocation(param: CurrentLocationParam): Maybe<Location>
}