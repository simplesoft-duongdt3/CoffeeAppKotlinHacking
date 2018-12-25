package com.huynh.xinh.data.responses.flash

import com.huynh.xinh.data.responses.flash.cloud.FlashApi
import com.huynh.xinh.domain.models.MetaData
import com.huynh.xinh.domain.repositories.FlashRepository
import io.reactivex.Observable
import org.mapstruct.factory.Mappers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class FlashRespositoryImpl
@Inject constructor(private val flashApi: FlashApi) : FlashRepository {

    override val getMetaData: Observable<MetaData>
        get() = flashApi.getMetaData.map { metadataDto ->
            Mappers.getMapper(FlashMapper::class.java).toMetaData(metadataDto)
        }.delay(3, TimeUnit.SECONDS)
}