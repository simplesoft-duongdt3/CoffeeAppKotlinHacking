package com.coffeetek.todo.feature.map

import com.coffeetek.todo.R
import com.google.android.gms.maps.model.LatLng
import com.huynh.xinh.domain.models.Store

/**
 * Create by Mr.X on 1/20/19
 */
class MapFragmentMapper {
    companion object {
        fun toMapViewModels(stores: List<Store>?): List<MarkerViewModel> {
            if (stores == null) {
                return emptyList()
            }

            val list = ArrayList<MarkerViewModel>(stores.size)
            for (store in stores) {
                list.add(toMapViewModel(store))
            }

            return list
        }

        private fun toMapViewModel(store: Store): MarkerViewModel {
            val latLng = LatLng(store.address?.lat ?: 0.0, store.address?.lng ?: 0.0)
            return MarkerViewModel(store.id, latLng, R.drawable.ic_pin, R.drawable.ic_pin_selected)
        }
    }
}