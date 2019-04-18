package com.example.photoreference.ui.menu

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.photoreference.data.menu.Category
import android.view.LayoutInflater
import com.example.photoreference.R

class MenuListAdapter(val list: List<Category>) : RecyclerView.Adapter<MenuHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MenuHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.menu_item
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.bind(list[position])
    }
}