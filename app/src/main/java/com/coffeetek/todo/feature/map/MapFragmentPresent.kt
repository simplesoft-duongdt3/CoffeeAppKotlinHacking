package com.coffeetek.todo.feature.map

import com.coffeetek.todo.base.presenter.BasePresenter
import com.coffeetek.todo.managners.metadata.IMetaDataManager
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

    private val mapPresenterViewModel = MapPresenterViewModel()

    override fun getStoreInfo(markerViewModel: MarkerViewModel) {
        val id = markerViewModel.id ?: 0

        val store = getStoreById(1)

        val name = store?.name ?: ""
        val mockMinDistance = 4.23
        val mockMinTime = 20.0
        val addressName = store?.address?.name ?: ""

        val storeViewModel = StoreViewModel(id, name, mockMinDistance, mockMinTime, addressName)

        getView()?.showStoreInfo(storeViewModel)
    }

    private fun getStoreById(id: Long): Store? {
        return mapPresenterViewModel.stores?.find { it.id == id }
    }

    override fun renderMarker() {
        getView()?.showMarker(MapFragmentMapper.toMapViewModels(getNearestStores()))
    }

    private fun getNearestStores(): List<Store> {
        val categories: List<Category> = metaDataManager.getMetaData()?.categories ?: emptyList()
        if (categories.isNotEmpty()) {
            mapPresenterViewModel.stores = categories[0].stores ?: emptyList()

            return mapPresenterViewModel.stores ?: emptyList()
        }
        return emptyList()
    }

}
