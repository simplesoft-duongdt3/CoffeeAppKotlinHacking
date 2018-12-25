package com.huynh.xinh.data.responses.flash.cloud

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by Mr.X on 12/25/18
 */
interface FlashApi {
    @get:GET("example-feed/feed.json")
    val getMetaData: Observable<MetaDataDto>
}
