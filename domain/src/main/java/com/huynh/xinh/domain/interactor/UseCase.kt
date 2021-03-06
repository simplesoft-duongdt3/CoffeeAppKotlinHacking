package com.huynh.xinh.domain.interactor

import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, Param>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(param: Param?): Observable<T>

    fun execute(observer: DisposableObserver<T>, param: Param) {
        val observable = this.buildUseCaseObservable(param)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun execute(observer: DisposableObserver<T>) {
        val observable = this.buildUseCaseObservable(null)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
