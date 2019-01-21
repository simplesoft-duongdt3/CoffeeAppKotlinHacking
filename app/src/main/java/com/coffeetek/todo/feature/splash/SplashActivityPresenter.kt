package com.coffeetek.todo.feature.splash

import com.coffeetek.todo.base.presenter.BasePresenter
import com.coffeetek.todo.feature.metadata.IMetaDataManager
import com.huynh.xinh.domain.interactor.OutputObserver
import com.huynh.xinh.domain.interactor.flash.GetMetaData
import com.huynh.xinh.domain.models.MetaData
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class SplashActivityPresenter
@Inject constructor(
    view: SplashActivityContract.View,
    private val getMetaData: GetMetaData,
    private val metaDataManager: IMetaDataManager
) :
    BasePresenter<SplashActivityContract.View>(view, getMetaData),
    SplashActivityContract.Presenter {

    override fun loadMetaData() {
        getMetaData.execute(object : OutputObserver<MetaData>() {
            override fun onNext(metaData: MetaData) {
                super.onNext(metaData)

                metaDataManager.setMetaData(metaData)

                getView()?.gotoMainScreen()
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                getView()?.showError()
            }
        })
    }

}