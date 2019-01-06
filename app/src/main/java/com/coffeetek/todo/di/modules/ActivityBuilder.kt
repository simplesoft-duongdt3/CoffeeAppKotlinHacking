package com.coffeetek.todo.di.modules

import com.coffeetek.todo.feature.main.MainActivity
import com.coffeetek.todo.feature.splash.SplashActivity
import com.coffeetek.todo.feature.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity

}