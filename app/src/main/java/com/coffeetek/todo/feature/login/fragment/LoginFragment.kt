package com.coffeetek.todo.feature.login.fragment

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
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
        ivFragmentLoginBack.setOnClickListener { activity?.finish() }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }
}