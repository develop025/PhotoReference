package com.example.photoreference.ui.list

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoreference.R
import com.example.photoreference.data.photo.Photo
import kotlinx.android.synthetic.main.photo.view.*

class PhotoViewHolder(view: View, private val imageSize: Point) : RecyclerView.ViewHolder(view) {

    fun bind(photo: Photo?) {
        val params = itemView.image.layoutParams
        params.height = imageSize.y
        itemView.image.layoutParams = params

        photo?.urlS?.let {
            Glide.with(itemView.image)
                .load(it)
                .into(itemView.image)
        }
    }

    companion object {
        fun create(parent: ViewGroup, imageSize: Point): PhotoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.photo, parent, false)
            return PhotoViewHolder(view, imageSize)
        }
    }
}