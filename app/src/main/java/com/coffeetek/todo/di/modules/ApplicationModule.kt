package com.coffeetek.todo.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.coffeetek.todo.CoffeeTekApplication
import com.coffeetek.todo.UiThread
import com.coffeetek.todo.feature.metadata.IMetaDataManager
import com.coffeetek.todo.feature.metadata.MetaDataManager
import com.huynh.xinh.data.executor.JobExecutor
import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(application: CoffeeTekApplication): Context {
        return application
    }

    @Singleton
    @Provides
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    internal fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    internal fun provideMetaDataManager(metaDataManager: MetaDataManager): IMetaDataManager {
        return metaDataManager
    }

    companion object {
        private const val PRE_NAME = "pref_coffee_tek"
    }
}
