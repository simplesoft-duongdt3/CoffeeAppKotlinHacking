package com.coffeetek.todo.feature.splash

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 12/25/18
 */
@Module
abstract class SplashActivityModule {
    @Binds
    abstract fun providePresenter(activityPresenter: SplashActivityPresenter): SplashActivityContract.Presenter

    @Binds
    abstract fun provideView(view: SplashActivity): SplashActivityContract.View
}