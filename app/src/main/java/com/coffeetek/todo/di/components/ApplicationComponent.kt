package com.coffeetek.todo.di.components

import android.app.Application
import com.coffeetek.todo.CoffeeTekApplication
import com.coffeetek.todo.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        ApplicationModule::class,
        NetworkModule::class,
        ApiModule::class,
        RepositoryModule::class,
        LocationModule::class]
)
interface ApplicationComponent : AndroidInjector<CoffeeTekApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
