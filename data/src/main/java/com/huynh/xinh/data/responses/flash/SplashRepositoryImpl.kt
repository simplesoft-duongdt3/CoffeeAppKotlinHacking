package com.huynh.xinh.data.responses.flash

import com.huynh.xinh.data.responses.flash.cloud.SplashApi
import com.huynh.xinh.domain.models.MetaData
import com.huynh.xinh.domain.repositories.flash.FlashRepository
import io.reactivex.Observable
import org.mapstruct.factory.Mappers
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class SplashRepositoryImpl @Inject constructor(private val splashApi: SplashApi) : FlashRepository {

    override fun getMetaData(): Observable<MetaData> {
        return splashApi.getMetaData.map { metadataDto ->
            Mappers.getMapper(SplashMapper::class.java).toMetaData(metadataDto)
        }
    }
}