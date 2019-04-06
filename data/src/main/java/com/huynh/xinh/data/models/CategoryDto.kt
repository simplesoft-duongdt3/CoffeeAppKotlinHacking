package com.huynh.xinh.data.models

/**
 * Create by Mr.X on 1/13/19
 */
data class CategoryDto @JvmOverloads constructor(
    val id: Long? = null,
    val name: String? = null,
    val stores: List<StoreDto>? = null
)