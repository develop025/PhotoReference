package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitCategories(
    @SerializedName("gitCategories")
    @Expose
    val gitCategories: List<GitCategory>? = null
)