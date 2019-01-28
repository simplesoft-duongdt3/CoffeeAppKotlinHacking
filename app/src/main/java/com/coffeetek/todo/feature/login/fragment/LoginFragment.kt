package com.coffeetek.todo.feature.login.fragment

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import com.coffeetek.todo.extensions.afterTextChanged
import com.coffeetek.todo.feature.main.MainActivity
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

        edtFragmentLoginEmail.afterTextChanged { hideEmailError() }
        edtFragmentLoginPassword.afterTextChanged { hidePasswordError() }

        tvFragmentLoginBtnLogin.setOnClickListener {
            presenter.login(
                edtFragmentLoginEmail.text.toString(),
                edtFragmentLoginPassword.text.toString()
            )
        }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun onLoginSuccess() {
        MainActivity.start(context)
    }

    override fun showEmailInValidError() {
        textInputLayoutFragmentLoginEmail.error = getString(R.string.all_email_invalid)
    }

    override fun showEmailRequiredError() {
        textInputLayoutFragmentLoginEmail.error = getString(R.string.all_field_required)
    }

    override fun hideEmailError() {
        textInputLayoutFragmentLoginEmail.error = null
    }

    override fun showPasswordInValid() {
        textInputLayoutFragmentLoginPassword.error = getString(R.string.all_password_invalid)
    }

    override fun showPasswordRequiredError() {
        textInputLayoutFragmentLoginPassword.error = getString(R.string.all_field_required)
    }

    override fun hidePasswordError() {
        textInputLayoutFragmentLoginPassword.error = null
    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}