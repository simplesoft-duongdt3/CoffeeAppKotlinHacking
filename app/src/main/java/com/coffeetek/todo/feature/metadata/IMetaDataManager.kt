package com.coffeetek.todo.feature.metadata

import com.huynh.xinh.domain.models.MetaData

/**
 * Create by Mr.X on 1/20/19
 */
interface IMetaDataManager {
    fun setMetaData(metadata: MetaData)

    fun getMetaData(): MetaData
}
