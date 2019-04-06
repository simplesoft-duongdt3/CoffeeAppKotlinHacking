package com.coffeetek.todo.feature.register

import com.coffeetek.todo.base.presenter.BasePresenter
import com.huynh.xinh.domain.interactor.OutputObserver
import com.huynh.xinh.domain.interactor.register.Register
import com.huynh.xinh.domain.interactor.register.RegisterValidationException
import com.huynh.xinh.domain.repositories.user.register.RegisterParam
import com.huynh.xinh.domain.repositories.user.register.RegisterResult
import com.huynh.xinh.domain.validation.errors.EmailInvalidError
import com.huynh.xinh.domain.validation.errors.PasswordInvalidError
import com.huynh.xinh.domain.validation.errors.RePasswordNotMatchError
import com.huynh.xinh.domain.validation.errors.RequiredFieldError
import javax.inject.Inject

class RegisterFragmentPresenter
@Inject constructor(view: RegisterFragmentContract.View, val register: Register) :
    BasePresenter<RegisterFragmentContract.View>(view),
    RegisterFragmentContract.Presenter {

    override fun register(registerRawInfo: RegisterRawInfo) {
        val param = RegisterParam(registerRawInfo.email, registerRawInfo.password, registerRawInfo.rePassword)
        register.execute(RegisterOutputObserver(), param)
    }


    inner class RegisterOutputObserver : OutputObserver<RegisterResult>() {
        override fun onNext(result: RegisterResult) {
            super.onNext(result)
            getView()?.onRegisterSuccess()
        }

        override fun onError(exception: Throwable) {
            super.onError(exception)

            when (exception) {
                is RegisterValidationException -> {

                    when (exception.emailValidationErrors.firstOrNull()) {
                        is EmailInvalidError -> {
                            getView()?.showEmailInValidError()
                        }
                        is RequiredFieldError -> {
                            getView()?.showEmailRequiredError()
                        }
                        else -> {
                            getView()?.hideEmailError()
                        }
                    }

                    when (exception.passwordValidationErrors.firstOrNull()) {
                        is PasswordInvalidError -> {
                            getView()?.showPasswordInValid()
                        }
                        is RequiredFieldError -> {
                            getView()?.showPasswordRequiredError()
                        }
                        else -> {
                            getView()?.hidePasswordError()
                        }
                    }

                    when (exception.rePasswordValidationErrors.firstOrNull()) {
                        is RePasswordNotMatchError -> {
                            getView()?.showRePasswordNotMatchError()
                        }
                        is RequiredFieldError -> {
                            getView()?.showRePasswordRequiredError()
                        }
                        else -> {
                            getView()?.hideRePasswordError()
                        }
                    }

                }
            }
        }
    }
}