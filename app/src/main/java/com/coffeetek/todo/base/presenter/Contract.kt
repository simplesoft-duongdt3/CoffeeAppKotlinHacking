package com.coffeetek.todo.base.presenter


interface Contract {
    interface IView

    interface IPresenter<V : IView> {
        fun setView(view: V)

        fun onResume()

        fun onPause()

        fun onStop()

        fun onDestroy()
    }
}
