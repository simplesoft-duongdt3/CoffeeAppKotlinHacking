package com.coffeetek.todo.di.modules

import com.huynh.xinh.data.responses.flash.cloud.SplashApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    internal fun getArticleApi(retrofit: Retrofit): SplashApi = retrofit.create(SplashApi::class.java)
}
