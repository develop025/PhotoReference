package com.example.photoreference.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.photoreference.R

class MainActivity : AppCompatActivity() {
    private lateinit var screenDelegate: IScreenDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screenDelegate = ScreenDelegate(this)
        screenDelegate.setFullScreen()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.navigate(R.id.listFragment)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenDelegate.onWindowFocusChanged(hasFocus)
    }
}
