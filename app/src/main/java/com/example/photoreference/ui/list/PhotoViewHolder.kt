package com.example.photoreference.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.photoreference.R
import com.example.photoreference.data.photo.Photo
import kotlinx.android.synthetic.main.photo.view.*

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(photo: Photo?) {
        photo?.urlS?.let {
            Glide.with(itemView.image)
                .load(it)
                .into(itemView.image)
        }
    }

    companion object {
        fun create(parent: ViewGroup): PhotoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.photo, parent, false)
            return PhotoViewHolder(view)
        }
    }
}