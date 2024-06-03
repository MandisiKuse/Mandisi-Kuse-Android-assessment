package com.glucode.about_you

import android.app.Application
import com.glucode.about_you.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AboutYouApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AboutYouApplication)
            androidLogger(Level.ERROR)
            modules(allModules)
        }
    }
}