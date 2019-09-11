package com.example.photoreference.frame

import android.app.Application
import com.example.photoreference.BuildConfig
import com.example.photoreference.di.referenceApp
import com.example.photoreference.util.CrashReportingTree
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class ReferenceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ReferenceApp)
            modules(referenceApp)
        }

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(CrashReportingTree())

    }
}