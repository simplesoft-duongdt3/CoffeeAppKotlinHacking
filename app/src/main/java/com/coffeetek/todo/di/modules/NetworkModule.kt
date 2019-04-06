package com.coffeetek.todo.di.modules

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    val header: Interceptor
        @Provides
        @Singleton
        get() {
            return Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build()
                )
            }
        }

    val httpLoggingInterceptor: HttpLoggingInterceptor
        @Provides
        @Singleton
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return logging
        }

    val gson: Gson
        @Provides
        @Singleton
        get() {
            val gsonBuilder = GsonBuilder()
            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            return gsonBuilder.create()
        }

    @Provides
    @Singleton
    fun getRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(
        cache: Cache,
        header: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(header)
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpCache(context: Application): Cache {
        return Cache(context.cacheDir, CACHE_SIZE)
    }

    companion object {
        private const val CACHE_SIZE = (10 * 1024 * 1024).toLong() // 10 M
        private const val BASE_URL = "https://gist.githubusercontent.com/HuynhXinh/"
    }

}
