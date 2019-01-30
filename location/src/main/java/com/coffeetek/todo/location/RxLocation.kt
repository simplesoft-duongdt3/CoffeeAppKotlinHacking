package com.coffeetek.todo.location

import com.huynh.xinh.domain.models.Location
import com.huynh.xinh.domain.repositories.location.CurrentLocationParam
import io.reactivex.Single

/**
 * Create by Mr.X on 1/29/19
 */
interface RxLocation {
    fun getCurrentLocation(param: CurrentLocationParam): Single<Location>
}