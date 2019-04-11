package com.example.photoreference.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SizeResponse(
    @SerializedName("sizes")
    @Expose
    private val sizes: Sizes? = null,
    @SerializedName("stat")
    @Expose
    private val stat: String? = null
)