package com.coffeetek.todo.feature.splash

import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity
import com.coffeetek.todo.feature.onboarding.OnBoardingActivity
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class SplashActivity : BaseActivity(), SplashActivityContract.View {
    override fun gotoMainScreen() {
        OnBoardingActivity.start(this)
        finish()
    }

    override fun showError() {

    }

    @Inject
    internal lateinit var presenter: SplashActivityContract.Presenter

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initEvent() {
        presenter.loadMetaData()
    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}