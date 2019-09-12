package com.example.photoreference.data.db.tables

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class TitleTypeConverter {
    private val gson = Gson()
    private val type = object : TypeToken<List<Title>>() {

    }.type

    @TypeConverter
    fun stringToNestedData(json: String): List<Title> {
        return gson.fromJson<List<Title>>(json, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: List<Title>): String {
        return gson.toJson(nestedData, type)
    }
}
