package com.huynh.xinh.domain.models

/**
 * Create by Mr.X on 1/13/19
 */
data class Address @JvmOverloads constructor(
    var id: Long? = null,
    var name: String? = null,
    var lat: Double? = null,
    var lng: Double? = null
)