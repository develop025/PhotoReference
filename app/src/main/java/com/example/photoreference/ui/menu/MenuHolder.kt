package com.example.photoreference.ui.menu

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.photoreference.data.menu.Category
import kotlinx.android.synthetic.main.menu_item.view.*
import java.util.*

class MenuHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(category: Category) {
        Glide.with(view.menuImage)
            .load(category.icon)
            .into(view.menuImage)

        val country = Locale.getDefault().country
        category.title?.forEach {
            if (it.language?.toLowerCase().equals(country.toLowerCase()))
                view.title.text = it.value
        }
    }
}
