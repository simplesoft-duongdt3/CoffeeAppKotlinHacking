package com.coffeetek.todo.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseActivity
import com.coffeetek.todo.base.ui.BaseFragment
import com.coffeetek.todo.feature.main.bottommaintab.OnBottomMainTabListener
import com.coffeetek.todo.feature.map.MapFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), OnBottomMainTabListener {
    override fun onClickTabHome() {

    }

    override fun onClickTabLocate() {
        showTab(mapFragment)
    }

    override fun onClickTabCart() {

    }

    override fun onClickTabProfile() {

    }

    private lateinit var mapFragment: MapFragment

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mapFragment = MapFragment.newInstance()
    }

    private fun showTab(fragment: BaseFragment) {
        hideAllFragments()

        if (fragment.isAdded) {
            showFragment(fragment)
        } else {
            addFragment(fragment)
            showFragment(fragment)
        }
    }

    private fun hideAllFragments() {
        hideFragment(mapFragment)
    }

    private fun showFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().show(fragment).commit()
    }

    private fun hideFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().hide(fragment).commit()
    }

    private fun addFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().add(R.id.flActivityMainContent, fragment).commit()
    }

    override fun initEvent() {
        bottomMainTabView.setOnBottomMainTabListener(this)
    }

    companion object {
        fun start(context: Context?) {
            val starter = Intent(context, MainActivity::class.java)
            context?.startActivity(starter)
        }
    }
}
