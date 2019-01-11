package com.coffeetek.todo.feature.onboarding.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OnBoardingFragmentProvider {
    @ContributesAndroidInjector(modules = [OnBoardingFragmentModule::class])
    internal abstract fun provideOnBoardingFragmentFactory(): OnBoardingFragment
}