package com.coffeetek.todo.base.ui

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import butterknife.ButterKnife

abstract class BaseLayout : RelativeLayout {
    private lateinit var rootCustomView: View

    protected abstract val contentView: Int

    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        getAttributeSet(context, attrs, defStyleAttr)
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {

        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        val inflater = LayoutInflater.from(context)

        rootCustomView = inflater.inflate(contentView, this, true)

        ButterKnife.bind(this, rootCustomView)

        obtainAttributeValues(context, attrs)

        initView(rootView)
    }

    private fun getAttributeSet(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        // handle in implement
    }

    protected abstract fun obtainAttributeValues(context: Context, attrs: AttributeSet?)

    protected abstract fun initView(view: View)

    fun onResume() {}

    fun onPause() {}

    fun onStop() {}

    fun onDestroy() {}

    fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {

    }
}