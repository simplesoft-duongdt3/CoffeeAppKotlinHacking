package com.coffeetek.todo.feature.main.bottommaintab

import android.support.v7.widget.AppCompatImageView

/**
 * Create by Mr.X on 1/6/19
 */
interface IBottomMainTabView {
    fun getTabHome(): AppCompatImageView
    fun getTabLocate(): AppCompatImageView
    fun getTabCart(): AppCompatImageView
    fun getTabProfile(): AppCompatImageView

    fun getOnBottomMainTabListener(): OnBottomMainTabListener?
}