package com.coffeetek.todo.feature.map

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MapFragmentProvider {
    @ContributesAndroidInjector(modules = [MapFragmentModule::class])
    internal abstract fun provideMapFragmentFactory(): MapFragment
}