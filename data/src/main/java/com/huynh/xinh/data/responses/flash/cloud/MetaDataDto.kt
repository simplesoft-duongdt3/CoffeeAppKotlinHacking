package com.huynh.xinh.data.responses.flash.cloud

import com.huynh.xinh.data.models.CategoryDto

data class MetaDataDto @JvmOverloads constructor(val categories: List<CategoryDto>? = null)
