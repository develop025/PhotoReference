package com.example.photoreference.data.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("photos")
    @Expose
    val photos: Photos,
    @SerializedName("stat")
    @Expose
    val stat: String
)