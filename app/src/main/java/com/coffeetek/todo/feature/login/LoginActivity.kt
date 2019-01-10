package com.coffeetek.todo.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity
import com.coffeetek.todo.feature.login.fragment.LoginFragment

/**
 * Create by Mr.X on 1/10/19
 */
class LoginActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_activity_login_content, LoginFragment.newInstance())
            .commit()
    }

    override fun initEvent() {

    }

    companion object {
        fun start(context: Context?) {
            val starter = Intent(context, LoginActivity::class.java)
            context?.startActivity(starter)
        }
    }

}