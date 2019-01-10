package com.coffeetek.todo.feature.onboarding.fragment

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/10/19
 */
interface OnBoardingFragmentContract {

    interface View : Contract.IView {
    }

    interface Presenter : Contract.IPresenter<View> {
    }
}