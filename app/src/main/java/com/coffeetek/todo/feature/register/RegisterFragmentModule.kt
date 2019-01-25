package com.coffeetek.todo.feature.register

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 1/10/19
 */
@Module
abstract class RegisterFragmentModule {
    @Binds
    abstract fun providePresenter(presenter: RegisterFragmentPresenter): RegisterFragmentContract.Presenter

    @Binds
    abstract fun provideView(view: RegisterFragment): RegisterFragmentContract.View
}