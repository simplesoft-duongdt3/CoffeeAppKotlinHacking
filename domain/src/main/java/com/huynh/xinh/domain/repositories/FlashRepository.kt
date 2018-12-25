package com.huynh.xinh.domain.repositories

import com.huynh.xinh.domain.models.MetaData
import io.reactivex.Observable

/**
 * Create by Mr.X on 12/25/18
 */
interface FlashRepository {
    val getMetaData: Observable<MetaData>
}