package com.coffeetek.todo.di.modules

import com.coffeetek.todo.feature.flash.FlashActivity
import com.coffeetek.todo.feature.flash.FlashActivityModule
import com.coffeetek.todo.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FlashActivityModule::class])
    internal abstract fun bindFlashActivity(): FlashActivity

    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity

}