package com.coffeetek.todo.feature.register

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

/**
 * Create by Mr.X on 1/24/19
 */
class RegisterFragment : BaseFragment(), RegisterFragmentContract.View {

    @Inject
    internal lateinit var presenter: RegisterFragmentContract.Presenter

    companion object {
        fun newInstance(): RegisterFragment {
            val args = Bundle()
            val fragment = RegisterFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override val contentView: Int
        get() = R.layout.fragment_register

    override fun initView(view: View?) {

    }

    override fun initEvent() {
        ivFragmentRegisterBack.setOnClickListener { activity?.finish() }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}