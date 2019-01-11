package com.coffeetek.todo.feature.onboarding

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 1/10/19
 */
@Module
abstract class OnBoardingActivityModule {
    @Binds
    abstract fun providePresenter(presenter: OnBoardingActivityPresenter): OnBoardingActivityContract.Presenter

    @Binds
    abstract fun provideView(view: OnBoardingActivity): OnBoardingActivityContract.View
}