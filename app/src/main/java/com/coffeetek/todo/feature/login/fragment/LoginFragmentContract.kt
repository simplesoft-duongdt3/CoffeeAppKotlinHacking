package com.coffeetek.todo.feature.login.fragment

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/10/19
 */
interface LoginFragmentContract {

    interface View : Contract.IView {
        fun showEmailInValidError()
        fun showEmailRequiredError()
        fun hideEmailInValidError()
        fun showPasswordInValid()
        fun showPasswordRequiredError()
        fun hidePasswordInValidError()
        fun onLoginSuccess()
    }

    interface Presenter : Contract.IPresenter<View> {
        fun login(email: String, password: String)
    }
}