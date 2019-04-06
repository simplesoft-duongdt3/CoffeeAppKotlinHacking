package com.coffeetek.todo.feature.register

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegisterFragmentProvider {
    @ContributesAndroidInjector(modules = [RegisterFragmentModule::class])
    internal abstract fun provideRegisterFragmentFactory(): RegisterFragment
}