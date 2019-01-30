package com.huynh.xinh.domain.models

/**
 * Create by Mr.X on 1/30/19
 */
data class GeoAddress(
    var lat: Double?,
    var lng: Double?,
    var addressName: String?,
    var city: String?,
    var state: String?,
    var country: String?,
    var postalCode: String?,
    var knownName: String?
)