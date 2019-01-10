package com.coffeetek.todo.feature.onboarding.fragment

import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import com.coffeetek.todo.feature.login.LoginActivity
import com.coffeetek.todo.feature.main.MainActivity
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

    }

    override fun initEvent() {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    @OnClick(R.id.tv_fragment_onboarding_register)
    fun onClickRegister() {
        MainActivity.start(context)
    }

    @OnClick(R.id.tv_fragment_onboarding_login)
    fun onClickLogin() {
        LoginActivity.start(context)
    }

    @OnClick(R.id.rl_fragment_onboarding_btn_facebook)
    fun onClickConnectWithFaceBook() {
        MainActivity.start(context)
    }
}