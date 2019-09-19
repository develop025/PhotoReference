package com.example.photoreference.data.db.tables

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String? = null,
    val order: String? = null,
    val icon: String? = null,
    val tag: String = "",
    @TypeConverters(TitleTypeConverter::class)
//    @Embedded(prefix = "media")
    val title: List<TitleCat>? = null
)