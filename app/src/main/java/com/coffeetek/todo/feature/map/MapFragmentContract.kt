package com.coffeetek.todo.feature.map

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/20/19
 */
interface MapFragmentContract {

    interface View : Contract.IView {
        fun showMarkers(mapViewModels: List<MarkerViewModel>)
        fun selectMarker(storeViewModel: StoreViewModel)
    }

    interface Presenter : Contract.IPresenter<View> {
        fun onMapViewReady()

        fun onMarkerClicked(markerViewModel: MarkerViewModel)
    }
}