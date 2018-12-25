package com.coffeetek.todo.base.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import butterknife.ButterKnife

abstract class BaseViewHolder<D>(parent: ViewGroup, @LayoutRes res: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(res, parent, false)) {

    protected val context: Context
        get() = itemView.context

    init {
        ButterKnife.bind(this, itemView)
    }

    abstract fun setData(itemViewModel: D, position: Int)
}