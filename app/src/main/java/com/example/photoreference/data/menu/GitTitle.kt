package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GitTitle(
    @SerializedName("language")
    @Expose
    val language: String? = null,
    @SerializedName("value")
    @Expose
    val value: String? = null
)