package com.coffeetek.todo.feature.main

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 12/25/18
 */
@Module
abstract class MainActivityModule {
    @Binds
    abstract fun providePresenter(activityPresenter: MainActivityPresenter): MainActivityContract.Presenter

    @Binds
    abstract fun provideView(view: MainActivity): MainActivityContract.View
}