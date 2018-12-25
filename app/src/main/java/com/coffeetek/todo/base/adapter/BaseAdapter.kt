package com.coffeetek.todo.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.coffeetek.todo.base.listeners.OnItemClickListener
import java.util.*

abstract class BaseAdapter<D, VH : BaseViewHolder<D>> : RecyclerView.Adapter<VH> {
    private var context: Context? = null
    private val data = ArrayList<D>()
    var onItemClickListener: OnItemClickListener<D>? = null

    constructor(context: Context) {
        init(context, emptyList())
    }

    constructor(context: Context, data: List<D>) {
        init(context, data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateViewHolderFactory(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract fun onCreateViewHolderFactory(parent: ViewGroup, viewType: Int): VH

    private fun init(context: Context, data: List<D>) {
        this.context = context
        this.data.addAll(data)
    }

    fun setData(data: List<D>) {
        this.data.clear()
        this.data.addAll(data)
    }

    fun getData() = data
}