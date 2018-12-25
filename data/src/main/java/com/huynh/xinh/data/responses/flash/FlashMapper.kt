package com.huynh.xinh.data.responses.flash

import com.huynh.xinh.data.responses.flash.cloud.MetaDataDto
import com.huynh.xinh.domain.models.MetaData
import org.mapstruct.Mapper

/**
 * Create by Mr.X on 12/25/18
 */
@Mapper
interface FlashMapper {
    fun toMetaData(metaDataDto: MetaDataDto): MetaData
}