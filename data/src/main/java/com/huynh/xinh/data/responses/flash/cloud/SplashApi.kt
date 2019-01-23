package com.huynh.xinh.data.responses.flash.cloud

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by Mr.X on 12/25/18
 */
interface SplashApi {
    @get:GET("a1b1315267b17c8ff2bd121189494470/raw/764414b536edad21a31ad533aee415499335406a/metadata.json")
    val getMetaData: Observable<MetaDataDto>
}
