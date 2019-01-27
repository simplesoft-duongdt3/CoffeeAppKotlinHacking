package com.huynh.xinh.domain.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Default [DisposableObserver] base class to be used whenever you want default error handling.
 */
open class OutputObserver<Result> : DisposableObserver<Result>() {
    override fun onNext(result: Result) {
        // no-op by default.
    }

    override fun onComplete() {
        // no-op by default.
    }

    override fun onError(exception: Throwable) {
        // no-op by default.
    }
}
