package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Title(
    @SerializedName("language")
    @Expose
    private val language: String? = null,
    @SerializedName("value")
    @Expose
    private val value: String? = null
)