package com.example.photoreference.data.menu

import androidx.room.Embedded
import androidx.room.Relation
import com.example.photoreference.data.db.tables.Category
import com.example.photoreference.data.db.tables.Title

class GitCategory(
    /*@SerializedName("id")
    @Expose
    val id: Int = 0,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("gitTitle")
    @Expose
    val gitTitle: List<GitTitle>? = null,
    @SerializedName("order")
    @Expose val order: String? = null,
    @SerializedName("icon")
    @Expose
    val icon: String? = null,
    @SerializedName("tag")
    @Expose
    val tag: String = ""*/

    @Embedded
    var category: Category,
    @Relation(parentColumn = "id", entityColumn = "categoryId", entity = Title::class)
    var titles: List<Title>? = null
)