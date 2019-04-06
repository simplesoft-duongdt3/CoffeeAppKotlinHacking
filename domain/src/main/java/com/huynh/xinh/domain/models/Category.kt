package com.huynh.xinh.domain.models

/**
 * Create by Mr.X on 1/13/19
 */
data class Category @JvmOverloads constructor(
    var id: Long? = null,
    var name: String? = null,
    var stores: List<Store>? = null
)
