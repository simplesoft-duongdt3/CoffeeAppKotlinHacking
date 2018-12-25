package com.coffeetek.todo.feature.flash

import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity
import com.coffeetek.todo.feature.main.MainActivity
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class FlashActivity : BaseActivity(), FlashActivityContract.View {
    override fun gotoMainScreen() {
        MainActivity.start(this)
        finish()
    }

    override fun showError() {

    }

    @Inject
    internal lateinit var presenter: FlashActivityContract.Presenter

    override val layoutId: Int
        get() = R.layout.activity_flash

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initEvent() {
        presenter.loadMetaData()
    }
}