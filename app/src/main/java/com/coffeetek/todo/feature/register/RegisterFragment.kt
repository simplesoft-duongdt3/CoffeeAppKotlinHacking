package com.coffeetek.todo.feature.register

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import com.coffeetek.todo.extensions.afterTextChanged
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

        edtFragmentRegisterEmail.afterTextChanged { hideEmailError() }
        edtFragmentRegisterPassword.afterTextChanged { hidePasswordError() }
        edtFragmentRegisterRePassword.afterTextChanged { hideRePasswordError() }

        tvFragmentRegisterBtnSignUp.setOnClickListener { presenter.register(getRegisterRowInfo()) }
    }

    private fun getRegisterRowInfo(): RegisterRawInfo {
        val email = edtFragmentRegisterEmail.text.toString()
        val password = edtFragmentRegisterPassword.text.toString()
        val rePassword = edtFragmentRegisterRePassword.text.toString()

        return RegisterRawInfo(email, password, rePassword)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun showEmailInValidError() {
        textInputLayoutFragmentRegisterEmail.error = getString(R.string.all_email_invalid)
    }

    override fun showEmailRequiredError() {
        textInputLayoutFragmentRegisterEmail.error = getString(R.string.all_field_required)
    }

    override fun hideEmailError() {
        textInputLayoutFragmentRegisterEmail.error = null
    }

    override fun showPasswordInValid() {
        textInputLayoutFragmentRegisterPassword.error = getString(R.string.all_password_invalid)
    }

    override fun showPasswordRequiredError() {
        textInputLayoutFragmentRegisterPassword.error = getString(R.string.all_field_required)
    }

    override fun hidePasswordError() {
        textInputLayoutFragmentRegisterPassword.error = null
    }

    override fun showRePasswordRequiredError() {
        textInputLayoutFragmentRegisterRePassword.error = getString(R.string.all_field_required)
    }

    override fun showRePasswordNotMatchError() {
        textInputLayoutFragmentRegisterRePassword.error = getString(R.string.fragment_register_password_not_match_error)
    }

    override fun hideRePasswordError() {
        textInputLayoutFragmentRegisterRePassword.error = null
    }

    override fun onRegisterSuccess() {
        activity?.finish()
    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}