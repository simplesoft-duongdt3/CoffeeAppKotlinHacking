package com.huynh.xinh.domain.repositories.location

import com.huynh.xinh.domain.models.Location

/**
 * Create by Mr.X on 1/30/19
 */
class GeoCoderParam(var location: Location? = null, var userQuery: String? = null, var maxResult: Int? = 5)