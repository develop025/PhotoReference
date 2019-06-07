package com.example.photoreference.ui.menu

import android.graphics.Point
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoreference.R
import com.example.photoreference.data.menu.Category

class MenuListAdapter(
    val list: List<Category>,
    private val horizontalListDelegate: HorizontalListDelegate,
    private val imageSize: Point,
    private val menuClickListener: MenuFragment.MenuClickListener
) : RecyclerView.Adapter<MenuHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MenuHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.main_menu_item
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.bind(horizontalListDelegate, list[position], imageSize,menuClickListener)
    }
}