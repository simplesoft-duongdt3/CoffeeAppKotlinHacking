package com.huynh.xinh.domain.repositories.flash

import com.huynh.xinh.domain.models.MetaData
import io.reactivex.Observable

/**
 * Create by Mr.X on 12/25/18
 */
interface FlashRepository {
    fun getMetaData(): Observable<MetaData>
}