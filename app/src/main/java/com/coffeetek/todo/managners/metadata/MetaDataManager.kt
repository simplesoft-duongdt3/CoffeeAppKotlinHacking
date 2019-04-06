package com.coffeetek.todo.managners.metadata

import com.huynh.xinh.domain.models.MetaData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Create by Mr.X on 1/20/19
 */
@Singleton
class MetaDataManager @Inject constructor() : IMetaDataManager {
    private var metadata: MetaData? = null

    companion object {
        val instance = MetaDataManager()
    }

    override fun setMetaData(metadata: MetaData) {
        this.metadata = metadata
    }

    override fun getMetaData(): MetaData? {
        return this.metadata
    }

}
