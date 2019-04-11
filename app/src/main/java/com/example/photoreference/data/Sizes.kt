package com.example.photoreference.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sizes (
    @SerializedName("canblog")
    @Expose
    private val canblog: Int? = null,
    @SerializedName("canprint")
    @Expose
    private val canprint: Int? = null,
    @SerializedName("candownload")
    @Expose
    private val candownload: Int? = null,
    @SerializedName("size")
    @Expose
    private val size: List<Size>? = null
    )