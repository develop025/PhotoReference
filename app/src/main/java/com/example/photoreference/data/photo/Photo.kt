package com.example.photoreference.data.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    @Expose
    val id: String? = null,
    @SerializedName("owner")
    @Expose
    private val owner: String? = null,
    @SerializedName("secret")
    @Expose
    private val secret: String? = null,
    @SerializedName("server")
    @Expose
    private val server: String? = null,
    @SerializedName("farm")
    @Expose
    private val farm: Int? = null,
    @SerializedName("title")
    @Expose
    private val title: String? = null,
    @SerializedName("ispublic")
    @Expose
    private val ispublic: Int? = null,
    @SerializedName("isfriend")
    @Expose
    private val isfriend: Int? = null,
    @SerializedName("isfamily")
    @Expose
    private val isfamily: Int? = null,
    @SerializedName("url_s")
    @Expose
    val urlS: String? = null,
    @SerializedName("height_s")
    @Expose
    private val heightS: String? = null,
    @SerializedName("width_s")
    @Expose
    private val widthS: String? = null
)