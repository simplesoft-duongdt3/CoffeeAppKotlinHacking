package com.coffeetek.todo.feature.flash

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 12/25/18
 */
interface FlashActivityContract {
    interface View : Contract.IView {
        fun gotoMainScreen()
        fun showError()
    }

    interface Presenter : Contract.IPresenter<View> {
        fun loadMetaData()
    }
}