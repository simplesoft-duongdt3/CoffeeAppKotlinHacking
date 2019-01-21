package com.coffeetek.todo.feature.map

import com.coffeetek.todo.base.presenter.BasePresenter
import com.coffeetek.todo.feature.metadata.IMetaDataManager
import com.huynh.xinh.domain.models.Category
import com.huynh.xinh.domain.models.Store
import javax.inject.Inject

/**
 * Create by Mr.X on 1/20/19
 */
class MapFragmentPresent
@Inject constructor(
    view: MapFragmentContract.View,
    private val metaDataManager: IMetaDataManager
) :
    BasePresenter<MapFragmentContract.View>(view), MapFragmentContract.Presenter {

    override fun renderMarker() {
        getView()?.showMarker(MapFragmentMapper.toMapViewModels(getNearestStores()))
    }

    private fun getNearestStores(): List<Store> {
        val categories: List<Category> = metaDataManager.getMetaData().categories ?: emptyList()
        if (categories.isNotEmpty()) {
            return categories[0].stores ?: emptyList()
        }
        return emptyList()
    }

}
