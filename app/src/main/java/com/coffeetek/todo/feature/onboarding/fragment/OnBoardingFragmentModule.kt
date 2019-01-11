package com.coffeetek.todo.feature.onboarding.fragment

import dagger.Binds
import dagger.Module

/**
 * Create by Mr.X on 1/10/19
 */
@Module
abstract class OnBoardingFragmentModule {
    @Binds
    abstract fun providePresenter(presenter: OnBoardingFragmentPresenter): OnBoardingFragmentContract.Presenter

    @Binds
    abstract fun provideView(view: OnBoardingFragment): OnBoardingFragmentContract.View
}