package com.coffeetek.todo

import android.content.Context
import android.support.multidex.MultiDex
import com.coffeetek.todo.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class CoffeeTekApplication : DaggerApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initFont()

        instance = this
    }

    private fun initFont() {
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SF-UI-Display-Medium.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .create(this)
            .build()
    }

    companion object {
        private var instance: CoffeeTekApplication? = null

        @JvmStatic
        fun getInstance(): CoffeeTekApplication = instance!!
    }
}
