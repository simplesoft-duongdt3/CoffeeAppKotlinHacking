package com.coffeetek.todo.feature.main.bottommaintab

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseLayout
import kotlinx.android.synthetic.main.bottom_main_tab_view.view.*

/**
 * Create by Mr.X on 1/6/19
 */
class BottomMainTabView : BaseLayout, IBottomMainTabView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    private lateinit var bottomMainTabState: BottomMainTabState

    private val onBottomMainTabListener: OnBottomMainTabListener? = null

    override fun getTabHome(): AppCompatImageView = iv_bottom_main_tab_home

    override fun getTabLocate(): AppCompatImageView = iv_bottom_main_tab_locate

    override fun getTabCart(): AppCompatImageView = iv_bottom_main_tab_cart

    override fun getTabProfile(): AppCompatImageView = iv_bottom_main_tab_profile

    override fun getOnBottomMainTabListener(): OnBottomMainTabListener? {
        return onBottomMainTabListener
    }

    override val contentView: Int
        get() = R.layout.bottom_main_tab_view

    override fun obtainAttributeValues(context: Context, attrs: AttributeSet?) {

    }

    override fun initView(view: View) {
        bottomMainTabState = BottomMainTabState.TAB_HOME_SELECTED
        bottomMainTabState.updateUi(this)
        bottomMainTabState.updateListener(this)
    }
}