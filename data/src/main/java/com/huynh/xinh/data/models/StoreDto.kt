package com.huynh.xinh.data.models

/**
 * Create by Mr.X on 1/13/19
 */
data class StoreDto @JvmOverloads constructor(
    val id: Long? = null,
    val name: String? = null,
    val address: AddressDto? = null
)