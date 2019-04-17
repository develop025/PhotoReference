package com.example.photoreference

import android.app.Application
import com.example.photoreference.di.referenceApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ReferenceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ReferenceApp)
            modules(referenceApp)
        }
    }
}