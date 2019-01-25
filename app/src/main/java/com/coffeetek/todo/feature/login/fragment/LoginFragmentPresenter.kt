package com.coffeetek.todo.feature.login.fragment

import com.coffeetek.todo.base.presenter.BasePresenter
import com.coffeetek.todo.validation.validators.EmailValidator
import com.coffeetek.todo.validation.validators.PasswordValidator
import javax.inject.Inject

class LoginFragmentPresenter
@Inject constructor(view: LoginFragmentContract.View) :
    BasePresenter<LoginFragmentContract.View>(view), LoginFragmentContract.Presenter {

    override fun login(email: String, password: String) {
        val emailValidator = EmailValidator(email)
        val passwordValidator = PasswordValidator(password)

        val isValid = emailValidator.isValid() && passwordValidator.isValid()
        if (isValid) {
            getView()?.onLoginSuccess()
        } else {
            if (!emailValidator.isValid()) {
                getView()?.showEmailInValidError(emailValidator.getMessage())
            } else {
                getView()?.hideEmailInValidError()
            }

            if (!passwordValidator.isValid()) {
                getView()?.showPasswordInValid(passwordValidator.getMessage())
            } else {
                getView()?.hidePasswordInValidError()
            }
        }
    }


}