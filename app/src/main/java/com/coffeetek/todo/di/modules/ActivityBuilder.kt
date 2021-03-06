package com.coffeetek.todo.di.modules

import com.coffeetek.todo.feature.login.LoginActivity
import com.coffeetek.todo.feature.login.fragment.LoginFragmentProvider
import com.coffeetek.todo.feature.main.MainActivity
import com.coffeetek.todo.feature.main.MainActivityModule
import com.coffeetek.todo.feature.map.MapFragmentProvider
import com.coffeetek.todo.feature.onboarding.OnBoardingActivity
import com.coffeetek.todo.feature.onboarding.OnBoardingActivityModule
import com.coffeetek.todo.feature.onboarding.fragment.OnBoardingFragmentProvider
import com.coffeetek.todo.feature.register.RegisterActivity
import com.coffeetek.todo.feature.register.RegisterFragmentProvider
import com.coffeetek.todo.feature.splash.SplashActivity
import com.coffeetek.todo.feature.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MapFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [OnBoardingActivityModule::class, OnBoardingFragmentProvider::class])
    internal abstract fun bindOnBoarding(): OnBoardingActivity

    @ContributesAndroidInjector(modules = [LoginFragmentProvider::class])
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RegisterFragmentProvider::class])
    internal abstract fun bindRegisterActivity(): RegisterActivity

}