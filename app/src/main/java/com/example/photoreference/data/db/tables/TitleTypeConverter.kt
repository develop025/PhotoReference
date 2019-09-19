package com.example.photoreference.data.db.tables

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class TitleTypeConverter {
    companion object {
        private val gson = Gson()
        private val type = object : TypeToken<List<TitleCat>>() {

        }.type

        @TypeConverter
        @JvmStatic
        fun stringToList(json: String): List<TitleCat> {
            return gson.fromJson<List<TitleCat>>(json, type)
        }

        @TypeConverter
        @JvmStatic
        fun listToString(list: List<TitleCat>): String {
            return gson.toJson(list, type)
        }
    }
}
