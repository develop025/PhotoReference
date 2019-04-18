package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Categories(
    @SerializedName("categories")
    @Expose
    val categories: List<Category>? = null
)