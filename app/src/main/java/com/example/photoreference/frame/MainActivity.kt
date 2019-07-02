package com.example.photoreference.frame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoreference.R
import com.example.photoreference.ui.screen.IScreenDelegate
import com.example.photoreference.ui.screen.ScreenDelegate

class MainActivity : AppCompatActivity() {
    private lateinit var screenDelegate: IScreenDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screenDelegate = ScreenDelegate(this)
        screenDelegate.setFullScreen()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenDelegate.onWindowFocusChanged(hasFocus)
    }
}
