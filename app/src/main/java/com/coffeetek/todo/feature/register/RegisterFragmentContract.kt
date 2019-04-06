package com.coffeetek.todo.feature.register

import com.coffeetek.todo.base.presenter.Contract

/**
 * Create by Mr.X on 1/24/19
 */
interface RegisterFragmentContract {

    interface View : Contract.IView {
        fun showEmailInValidError()
        fun showEmailRequiredError()
        fun hideEmailError()

        fun showPasswordInValid()
        fun showPasswordRequiredError()
        fun hidePasswordError()

        fun showRePasswordRequiredError()
        fun showRePasswordNotMatchError()
        fun hideRePasswordError()

        fun onRegisterSuccess()
    }

    interface Presenter : Contract.IPresenter<View> {
        fun register(registerRawInfo: RegisterRawInfo)
    }
}
