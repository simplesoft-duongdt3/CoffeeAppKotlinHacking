package com.coffeetek.todo.managners.location

import com.huynh.xinh.domain.models.GeoAddress

/**
 * Create by Mr.X on 1/29/19
 */
interface MyLocationManager {
    fun getLocation(): GeoAddress
    fun setLocation(geoAddress: GeoAddress)
}