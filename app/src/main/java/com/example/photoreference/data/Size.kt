package com.example.photoreference.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Size(
    @SerializedName("label")
    @Expose
    private val label: String? = null,
    @SerializedName("width")
    @Expose
    private val width: String? = null,
    @SerializedName("height")
    @Expose
    private val height: String? = null,
    @SerializedName("source")
    @Expose
    private val source: String? = null,
    @SerializedName("url")
    @Expose
    private val url: String? = null,
    @SerializedName("media")
    @Expose
    private val media: String? = null
)