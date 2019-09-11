package com.example.photoreference.data.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gitCategories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String? = null,
    val order: String? = null,
    val icon: String? = null,
    val tag: String = ""
)