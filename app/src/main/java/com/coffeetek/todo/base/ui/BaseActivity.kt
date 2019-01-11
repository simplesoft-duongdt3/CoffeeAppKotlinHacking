package com.coffeetek.todo.base.ui

import android.os.Bundle
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)

        initView(savedInstanceState)
        initData()
        initEvent()
    }

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun initEvent()

    protected fun initData() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
