package com.coffeetek.todo.feature.login.fragment

import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import javax.inject.Inject

/**
 * Create by Mr.X on 1/10/19
 */
class LoginFragment : BaseFragment(), LoginFragmentContract.View {

    @Inject
    internal lateinit var presenter: LoginFragmentContract.Presenter

    companion object {
        fun newInstance(): LoginFragment {
            val args = Bundle()
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override val contentView: Int
        get() = R.layout.fragment_login

    override fun initView(view: View?) {

    }

    override fun initEvent() {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    @OnClick(R.id.iv_fragment_login_back)
    fun onClickBack() {
        activity?.finish()
    }
}