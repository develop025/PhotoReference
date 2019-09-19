package com.example.photoreference.data.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "titles")
class TitleCat {
    @field:PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var categoryId: Int = 0
    var language: String? = null
    var value: String? = null
}