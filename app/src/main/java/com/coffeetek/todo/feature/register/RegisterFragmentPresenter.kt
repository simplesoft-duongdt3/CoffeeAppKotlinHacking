package com.coffeetek.todo.feature.register

import com.coffeetek.todo.base.presenter.BasePresenter
import javax.inject.Inject

class RegisterFragmentPresenter
@Inject constructor(view: RegisterFragmentContract.View) : BasePresenter<RegisterFragmentContract.View>(view),
    RegisterFragmentContract.Presenter {

}