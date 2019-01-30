package com.coffeetek.todo.feature.main

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/29/19
 */
interface MainActivityContract {

    interface View : Contract.IView {
        fun showCurrentLocationError()
    }

    interface Presenter : Contract.IPresenter<View> {
        fun getCurrentLocation()
    }
}