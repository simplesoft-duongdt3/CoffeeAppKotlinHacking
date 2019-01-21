package com.huynh.xinh.data.responses.flash.cloud

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by Mr.X on 12/25/18
 */
interface SplashApi {
    @get:GET("a1b1315267b17c8ff2bd121189494470/raw/fcb58feadd448db4d231c9e07abcaecb695a0a66/metadata.json")
    val getMetaData: Observable<MetaDataDto>
}
