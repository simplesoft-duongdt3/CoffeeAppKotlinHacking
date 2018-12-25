package com.coffeetek.todo.base.listeners

@FunctionalInterface
interface OnItemClickListener<D> {

    fun onItemClick(itemViewModel: D, position: Int)
}