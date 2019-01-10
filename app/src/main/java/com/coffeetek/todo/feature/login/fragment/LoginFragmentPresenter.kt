package com.coffeetek.todo.feature.login.fragment

import com.coffeetek.todo.base.presenter.BasePresenter
import javax.inject.Inject

class LoginFragmentPresenter
@Inject constructor(view: LoginFragmentContract.View) :
    BasePresenter<LoginFragmentContract.View>(view), LoginFragmentContract.Presenter {


}