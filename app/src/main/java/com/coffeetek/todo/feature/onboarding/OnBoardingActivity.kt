package com.coffeetek.todo.feature.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity
import com.coffeetek.todo.feature.onboarding.fragment.OnBoardingFragment
import javax.inject.Inject

/**
 * Create by Mr.X on 1/10/19
 */
class OnBoardingActivity : BaseActivity(), OnBoardingActivityContract.View {

    @Inject
    internal lateinit var presenter: OnBoardingActivityContract.Presenter

    override val layoutId: Int
        get() = R.layout.activity_on_boarding

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flActivityOnBoardingContent, OnBoardingFragment.newInstance())
            .commit()
    }

    override fun initEvent() {

    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, OnBoardingActivity::class.java)
            context.startActivity(starter)
        }
    }
}