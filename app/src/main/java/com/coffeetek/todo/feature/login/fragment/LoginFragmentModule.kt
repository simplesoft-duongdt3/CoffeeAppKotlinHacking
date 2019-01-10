package com.coffeetek.todo.feature.login.fragment

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 1/10/19
 */
@Module
abstract class LoginFragmentModule {
    @Binds
    abstract fun providePresenter(presenter: LoginFragmentPresenter): LoginFragmentContract.Presenter

    @Binds
    abstract fun provideView(view: LoginFragment): LoginFragmentContract.View
}