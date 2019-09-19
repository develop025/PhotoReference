package com.example.photoreference.data.menu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitCategory(
    @SerializedName("id")
    @Expose
    val id: Int = 0,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("title")
    @Expose
    val gitTitle: List<GitTitle>? = null,
    @SerializedName("order")
    @Expose val order: String? = null,
    @SerializedName("icon")
    @Expose
    val icon: String? = null,
    @SerializedName("tag")
    @Expose
    val tag: String = ""

    /*@Embedded
    var category: Category*/
//    ,
    /*@Relation(parentColumn = "id", entityColumn = "categoryId", entity = TitleCat::class)
    var titles: List<TitleCat>? = null*/
)