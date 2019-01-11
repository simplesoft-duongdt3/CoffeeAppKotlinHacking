package com.coffeetek.todo.feature.onboarding.fragment

import com.coffeetek.todo.base.presenter.BasePresenter
import javax.inject.Inject

class OnBoardingFragmentPresenter
@Inject constructor(view: OnBoardingFragmentContract.View) :
    BasePresenter<OnBoardingFragmentContract.View>(view), OnBoardingFragmentContract.Presenter {


}