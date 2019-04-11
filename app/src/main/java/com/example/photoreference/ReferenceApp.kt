package com.example.photoreference

import android.app.Application
import com.example.photoreference.di.referenceApp
import org.koin.android.ext.android.startKoin

class ReferenceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, referenceApp)
    }
}