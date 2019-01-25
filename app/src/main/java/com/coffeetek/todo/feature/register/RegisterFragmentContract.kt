package com.coffeetek.todo.feature.register

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/24/19
 */
interface RegisterFragmentContract {

    interface View : Contract.IView {
    }

    interface Presenter : Contract.IPresenter<View> {
    }
}
