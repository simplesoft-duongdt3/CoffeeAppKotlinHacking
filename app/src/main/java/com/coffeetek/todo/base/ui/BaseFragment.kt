package com.coffeetek.todo.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    protected abstract val contentView: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = view
        if (view == null) {
            view = inflater.inflate(contentView, container, false)
            ButterKnife.bind(this, view!!)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initEvent()
        initData(savedInstanceState)
    }

    protected abstract fun initView(view: View?)

    protected abstract fun initEvent()

    protected abstract fun initData(savedInstanceState: Bundle?)

}
