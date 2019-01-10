package com.coffeetek.todo.feature.onboarding

import com.coffeetek.todo.base.presenter.BasePresenter
import javax.inject.Inject

class OnBoardingActivityPresenter
@Inject constructor(view: OnBoardingActivityContract.View) :
    BasePresenter<OnBoardingActivityContract.View>(view),
    OnBoardingActivityContract.Presenter {

}