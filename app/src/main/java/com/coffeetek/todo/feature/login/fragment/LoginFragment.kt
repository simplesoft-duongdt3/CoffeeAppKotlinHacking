package com.coffeetek.todo.feature.login.fragment

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.text.Editable
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.SimpleTextWatcher
import com.coffeetek.todo.base.ui.BaseFragment
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

        edtFragmentLoginEmail.afterTextChanged { hideEmailInValidError() }
        edtFragmentLoginPassword.afterTextChanged { hidePasswordInValidError() }

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

    override fun showEmailInValidError(message: String) {
        textInputLayoutFragmentLoginEmail.error = message
    }

    override fun hideEmailInValidError() {
        textInputLayoutFragmentLoginEmail.error = null
    }

    override fun showPasswordInValid(message: String) {
        textInputLayoutFragmentLoginPassword.error = message
    }

    override fun hidePasswordInValidError() {
        textInputLayoutFragmentLoginPassword.error = null
    }

    private fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}