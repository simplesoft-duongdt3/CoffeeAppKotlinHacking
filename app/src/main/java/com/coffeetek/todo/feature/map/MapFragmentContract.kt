package com.coffeetek.todo.feature.map

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/20/19
 */
interface MapFragmentContract {

    interface View : Contract.IView {
        fun showMarker(mapViewModels: List<MarkerViewModel>)
    }

    interface Presenter : Contract.IPresenter<View> {
        fun renderMarker()
    }
}