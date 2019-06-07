package com.example.photoreference.ui.main

import android.graphics.Point
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoreference.R
import com.example.photoreference.data.Repo
import com.example.photoreference.ui.screen.DpTransformation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val repo: Repo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val screenProportion = size.y.toFloat() / size.x.toFloat()

        val imageSize = Point()
        imageSize.x = (size.x - 6 * DpTransformation.dpToPx(resources.getDimension(R.dimen.listMargin)))/3
        imageSize.y = (imageSize.x * screenProportion).toInt()
        repo.imageSize = imageSize
    }
}
