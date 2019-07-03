package com.example.photoreference.ui.screen

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue


class DpTransformation {

    companion object {
        /*  fun dpToPx(dp: Float, context: Context): Int {
              return TypedValue.applyDimension(
                  TypedValue.COMPLEX_UNIT_DIP,
                  dp,
                  context.resources.displayMetrics
              ).toInt()
          }*/

        fun dpToPx(dp: Float): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun pxToDp(px: Int): Float {
            return (px / Resources.getSystem().displayMetrics.density)
        }

        fun spToPx(sp: Float, context: Context): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                context.resources.displayMetrics
            ).toInt()
        }

        fun dpToSp(dp: Float, context: Context): Int {
            return (dpToPx(dp) / context.resources.displayMetrics.scaledDensity).toInt()
        }
    }
}