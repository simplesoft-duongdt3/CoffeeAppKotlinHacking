package com.coffeetek.todo.managners.location

import com.huynh.xinh.domain.models.GeoAddress
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Create by Mr.X on 1/29/19
 */
@Singleton
class MyLocationManagerImpl @Inject constructor() : MyLocationManager {
    private lateinit var geoAddress: GeoAddress

    companion object {
        val instance = MyLocationManagerImpl()
    }

    override fun getLocation(): GeoAddress {
        return geoAddress
    }

    override fun setLocation(geoAddress: GeoAddress) {
        this.geoAddress = geoAddress
    }
}