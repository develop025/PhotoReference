package com.example.photoreference.frame

import android.app.Application
import com.example.photoreference.di.referenceApp
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ReferenceApp : Application() {

    override fun onCreate() {
        Stetho.initializeWithDefaults(this)
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ReferenceApp)
            modules(referenceApp)
        }
    }
}