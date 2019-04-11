package com.example.photoreference.ui.main

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.View

class ScreenDelegate(private val activity: AppCompatActivity) :
    IScreenDelegate {
    private var currentApiVersion: Int = 0

    override fun setFullScreen() {
        currentApiVersion = android.os.Build.VERSION.SDK_INT

        val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {

            activity.window.decorView.systemUiVisibility = flags

            val decorView = activity.window.decorView
            decorView
                .setOnSystemUiVisibilityChangeListener { visibility ->
                    if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN === 0) {
                        decorView.systemUiVisibility = flags
                    }
                }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            activity.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}
