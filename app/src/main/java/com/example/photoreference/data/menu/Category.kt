package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Category(
    @SerializedName("id")
    @Expose
    private val id: String? = null,
    @SerializedName("name")
    @Expose
    private val name: String? = null,
    @SerializedName("title")
    @Expose
    val title: List<Title>? = null,
    @SerializedName("order")
    @Expose
    private val order: String? = null,
    @SerializedName("icon")
    @Expose
    val icon: String? = null,
    @SerializedName("tag")
    @Expose
    private val tag: String? = null
)