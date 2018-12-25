package com.coffeetek.todo.feature.flash

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 12/25/18
 */
@Module
abstract class FlashActivityModule {
    @Binds
    abstract fun providePresenter(activityPresenter: FlashActivityPresenter): FlashActivityContract.Presenter

    @Binds
    abstract fun provideView(view: FlashActivity): FlashActivityContract.View
}