package com.coffeetek.todo.feature.map

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 1/10/19
 */
@Module
abstract class MapFragmentModule {
    @Binds
    abstract fun providePresenter(presenter: MapFragmentPresent): MapFragmentContract.Presenter

    @Binds
    abstract fun provideView(view: MapFragment): MapFragmentContract.View
}