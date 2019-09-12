package com.example.photoreference.data.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String? = null,
    val order: String? = null,
    val icon: String? = null,
    val tag: String = "",
    @Expose
    val title: List<Title>
)