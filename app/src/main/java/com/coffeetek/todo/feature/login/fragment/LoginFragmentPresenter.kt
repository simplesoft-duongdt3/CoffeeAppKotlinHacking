package com.coffeetek.todo.feature.login.fragment

import com.coffeetek.todo.base.presenter.BasePresenter
import com.huynh.xinh.domain.interactor.OutputObserver
import com.huynh.xinh.domain.interactor.login.Login
import com.huynh.xinh.domain.interactor.login.LoginValidationException
import com.huynh.xinh.domain.repositories.user.LoginParam
import com.huynh.xinh.domain.repositories.user.LoginResult
import com.huynh.xinh.domain.validation.errors.EmailInvalidError
import com.huynh.xinh.domain.validation.errors.PasswordInvalidError
import com.huynh.xinh.domain.validation.errors.RequiredFieldError
import javax.inject.Inject

class LoginFragmentPresenter
@Inject constructor(view: LoginFragmentContract.View, val login: Login) :
    BasePresenter<LoginFragmentContract.View>(view), LoginFragmentContract.Presenter {

    override fun login(email: String, password: String) {
        val param = LoginParam(email, password)

        login.execute(
            object : OutputObserver<LoginResult>() {
                override fun onNext(result: LoginResult) {
                    super.onNext(result)
                    getView()?.onLoginSuccess()
                }

                override fun onError(exception: Throwable) {
                    super.onError(exception)
                    when (exception) {
                        is LoginValidationException -> {
                            exception.emailValidationErrors.forEach {
                                when (it) {
                                    is EmailInvalidError -> {
                                        getView()?.showEmailInValidError()
                                    }
                                    is RequiredFieldError -> {
                                        getView()?.showEmailRequiredError()
                                    }
                                }
                            }

                            exception.passwordValidationErrors.forEach {
                                when (it) {
                                    is PasswordInvalidError -> {
                                        getView()?.showPasswordInValid()
                                    }
                                    is RequiredFieldError -> {
                                        getView()?.showPasswordRequiredError()
                                    }
                                }
                            }
                        }
                    }
                }
            },
            param
        )
    }


}