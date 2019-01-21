package com.coffeetek.todo.feature.onboarding.fragment

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import com.coffeetek.todo.feature.login.LoginActivity
import com.coffeetek.todo.feature.main.MainActivity
import kotlinx.android.synthetic.main.fragment_onboarding.*
import javax.inject.Inject

/**
 * Create by Mr.X on 1/10/19
 */
class OnBoardingFragment : BaseFragment(), OnBoardingFragmentContract.View {

    @Inject
    internal lateinit var presenter: OnBoardingFragmentContract.Presenter

    companion object {
        fun newInstance(): OnBoardingFragment {
            val args = Bundle()
            val fragment = OnBoardingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override val contentView: Int
        get() = R.layout.fragment_onboarding

    override fun initView(view: View?) {
        tvFragmentOnBoardingRegister.setOnClickListener { MainActivity.start(context) }
        tvFragmentOnBoardingLogin.setOnClickListener { LoginActivity.start(context) }
        rlFragmentOnBoardingBtnFacebook.setOnClickListener { MainActivity.start(context) }
    }

    override fun initEvent() {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}