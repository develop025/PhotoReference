package com.example.photoreference.ui.list

import android.graphics.Point
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.photoreference.data.photo.Photo

class PhotosListAdapter(val imageSize: Point) :
    PagedListAdapter<Photo, RecyclerView.ViewHolder>(PhotoDiffCallback) {

    companion object {
        private const val DATA_VIEW_TYPE = 1
        private const val FOOTER_VIEW_TYPE = 2

        val PhotoDiffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoViewHolder.create(parent,imageSize)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) DATA_VIEW_TYPE else FOOTER_VIEW_TYPE
    }
}