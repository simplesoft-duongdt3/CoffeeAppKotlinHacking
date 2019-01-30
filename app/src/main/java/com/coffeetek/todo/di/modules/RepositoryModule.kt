package com.coffeetek.todo.di.modules

import com.huynh.xinh.data.responses.flash.SplashRepositoryImpl
import com.huynh.xinh.data.responses.location.LocationRepositoryImpl
import com.huynh.xinh.data.responses.user.UserRepositoryImpl
import com.huynh.xinh.domain.repositories.flash.FlashRepository
import com.huynh.xinh.domain.repositories.location.LocationRepository
import com.huynh.xinh.domain.repositories.user.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    internal abstract fun provideFlashRepository(impl: SplashRepositoryImpl): FlashRepository

    @Binds
    internal abstract fun provideUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    internal abstract fun provideLocationRepository(impl: LocationRepositoryImpl): LocationRepository
}
