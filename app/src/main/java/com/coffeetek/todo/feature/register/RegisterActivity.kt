package com.coffeetek.todo.feature.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity

/**
 * Create by Mr.X on 1/24/19
 */
class RegisterActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flActivityLoginContent, RegisterFragment.newInstance())
            .commit()
    }

    override fun initEvent() {

    }

    companion object {
        fun start(context: Context?) {
            val starter = Intent(context, RegisterActivity::class.java)
            context?.startActivity(starter)
        }
    }
}