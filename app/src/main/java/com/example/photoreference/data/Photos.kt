package com.example.photoreference.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Photos(
    @SerializedName("page")
    @Expose
    private val page: Int? = null,
    @SerializedName("pages")
    @Expose
    private val pages: Int? = null,
    @SerializedName("perpage")
    @Expose
    private val perpage: Int? = null,
    @SerializedName("total")
    @Expose
    private val total: Int? = null,
    @SerializedName("photo")
    @Expose val photo: List<Photo>? = null
)