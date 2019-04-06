package com.huynh.xinh.data.responses.flash

import com.huynh.xinh.data.models.AddressDto
import com.huynh.xinh.data.models.CategoryDto
import com.huynh.xinh.data.models.StoreDto
import com.huynh.xinh.data.responses.flash.cloud.MetaDataDto
import com.huynh.xinh.domain.models.Address
import com.huynh.xinh.domain.models.Category
import com.huynh.xinh.domain.models.MetaData
import com.huynh.xinh.domain.models.Store
import org.mapstruct.Mapper

/**
 * Create by Mr.X on 12/25/18
 */
@Mapper
interface SplashMapper {
    fun toMetaData(metaDataDto: MetaDataDto): MetaData

    fun toCategories(categories: List<CategoryDto>): List<Category>

    fun toCategory(category: CategoryDto): Category

    fun toStores(stores: List<StoreDto>): List<Store>

    fun toStore(store: StoreDto): Store

    fun toAddress(address: AddressDto): Address
}