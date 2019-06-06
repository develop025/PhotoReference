package com.example.photoreference.ui.menu

import android.view.ViewGroup
import com.example.photoreference.data.menu.Category
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.photoreference.R

class MenuListAdapter(
    val list: List<Category>,
    private val menuClickListener: MenuFragment.MenuClickListener
) : RecyclerView.Adapter<MenuHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MenuHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.menu_item
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.bind(list[position], menuClickListener)
    }
}