package com.example.photoreference.data.menu

import com.example.photoreference.data.db.tables.Category
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GitCategories(
    @SerializedName("categories")
    @Expose
    val gitCategories: List<Category>? = null
)