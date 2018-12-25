package com.coffeetek.todo.di.modules

import com.huynh.xinh.data.responses.flash.FlashRespositoryImpl
import com.huynh.xinh.domain.repositories.FlashRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    internal abstract fun provideFlashRepository(impl: FlashRespositoryImpl): FlashRepository
}
