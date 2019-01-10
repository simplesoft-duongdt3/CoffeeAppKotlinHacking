package com.coffeetek.todo.base.presenter

import com.huynh.xinh.domain.interactor.UseCase
import java.lang.ref.WeakReference
import java.util.*

abstract class BasePresenter<V : Contract.IView> : Contract.IPresenter<V> {

    private val useCases: List<UseCase<*, *>>

    private var view: WeakReference<V>? = null

    protected val isViewNull: Boolean
        get() = view == null || view!!.get() == null

    constructor() {
        this.useCases = emptyList()
    }

    constructor(view: V, vararg useCases: UseCase<*, *>) {
        setView(view)
        this.useCases = Arrays.asList<UseCase<*, *>>(*useCases)
    }

    constructor(vararg useCases: UseCase<*, *>) {
        this.useCases = Arrays.asList<UseCase<*, *>>(*useCases)
    }

    constructor(view: V) {
        setView(view)
        this.useCases = emptyList()
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {}

    override fun onDestroy() {
        for (useCase in useCases) {
            useCase.dispose()
        }
        view = null
    }

    protected fun getView(): V? {
        return view!!.get()
    }

    final override fun setView(view: V) {
        this.view = WeakReference(view)
    }
}
