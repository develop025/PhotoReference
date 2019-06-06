package com.example.photoreference.ui.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.top = space
        outRect.bottom = space
        when (parent.getChildLayoutPosition(view) % 2) {
            0 -> outRect.right = space
            else -> outRect.left = space
        }
        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1) {
            outRect.top = space * 2
        }
    }
}
