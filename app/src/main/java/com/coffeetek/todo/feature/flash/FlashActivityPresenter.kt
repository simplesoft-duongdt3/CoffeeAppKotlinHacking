package com.coffeetek.todo.feature.flash

import com.coffeetek.todo.base.presenter.BasePresenter
import com.huynh.xinh.domain.interactor.OutputObserver
import com.huynh.xinh.domain.interactor.flash.GetMetaData
import com.huynh.xinh.domain.models.MetaData
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class FlashActivityPresenter
@Inject constructor(view: FlashActivityContract.View, private val getMetaData: GetMetaData) :
    BasePresenter<FlashActivityContract.View>(view, getMetaData),
    FlashActivityContract.Presenter {
    override fun loadMetaData() {
        getMetaData.execute(object : OutputObserver<MetaData>() {
            override fun onNext(t: MetaData) {
                super.onNext(t)
                getView()?.gotoMainScreen()
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                getView()?.showError()
            }
        })
    }

}