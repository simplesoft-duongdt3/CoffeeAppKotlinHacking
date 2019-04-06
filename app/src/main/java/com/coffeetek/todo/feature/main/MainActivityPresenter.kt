package com.coffeetek.todo.feature.main

import android.util.Log
import com.coffeetek.todo.base.presenter.BasePresenter
import com.coffeetek.todo.managners.location.MyLocationManager
import com.huynh.xinh.domain.interactor.OutputObserver
import com.huynh.xinh.domain.interactor.location.GetCurrentLocation
import com.huynh.xinh.domain.models.GeoAddress
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    view: MainActivityContract.View,
    private val myLocationManager: MyLocationManager,
    private val getCurrentLocation: GetCurrentLocation
) : BasePresenter<MainActivityContract.View>(view, getCurrentLocation),
    MainActivityContract.Presenter {

    override fun getCurrentLocation() {
        getCurrentLocation.execute(object : OutputObserver<GeoAddress>() {
            override fun onNext(result: GeoAddress) {
                super.onNext(result)
                myLocationManager.setLocation(result)
                Log.i("getCurrentLocation ", result.toString())
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                getView()?.showCurrentLocationError()
            }
        })
    }
}