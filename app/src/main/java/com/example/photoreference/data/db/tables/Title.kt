package com.example.photoreference.data.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "titles")
data class Title(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val categoryId: Int,
    val language: String? = null,
    val value: String? = null
)