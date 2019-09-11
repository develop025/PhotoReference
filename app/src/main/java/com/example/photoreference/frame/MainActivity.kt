package com.example.photoreference.frame

import android.graphics.Point
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoreference.R
import com.example.photoreference.data.repo.CategoriesRepo
import com.example.photoreference.ui.screen.DpTransformation
import com.example.photoreference.ui.screen.IScreenDelegate
import com.example.photoreference.ui.screen.ScreenDelegate
import org.koin.android.ext.android.inject
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var screenDelegate: IScreenDelegate
    private val categoriesRepo: CategoriesRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screenDelegate = ScreenDelegate(this)
        screenDelegate.setFullScreen()
        determineScreenSize()
        determineLanguage()
    }

    private fun determineLanguage() {
        categoriesRepo.language = Locale.getDefault().language
    }

    private fun determineScreenSize() {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val screenProportion = size.y.toFloat() / size.x.toFloat()

        val imageSize = Point()
        imageSize.x =
            (size.x - 6 * DpTransformation.dpToPx(resources.getDimension(R.dimen.listMargin))) / 3
        imageSize.y = (imageSize.x * screenProportion).toInt()
        categoriesRepo.imageSize = imageSize
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        screenDelegate.onWindowFocusChanged(hasFocus)
    }
}
