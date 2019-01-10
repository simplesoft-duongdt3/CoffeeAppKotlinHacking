package com.coffeetek.todo.di.modules

import com.coffeetek.todo.feature.main.MainActivity
import com.coffeetek.todo.feature.onboarding.OnBoardingActivity
import com.coffeetek.todo.feature.onboarding.OnBoardingActivityModule
import com.coffeetek.todo.feature.onboarding.fragment.OnBoardingFragmentProvider
import com.coffeetek.todo.feature.splash.SplashActivity
import com.coffeetek.todo.feature.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [OnBoardingActivityModule::class, OnBoardingFragmentProvider::class])
    internal abstract fun bindOnBoarding(): OnBoardingActivity

    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity

}