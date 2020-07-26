package com.v15h4l.vishalpoc.data.country.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson by lazy { Gson() }

    // Handle String List
    @TypeConverter
    fun fromStringList(list: List<String>): String? = gson.toJson(list)

    @TypeConverter
    fun toStringList(stringListString: String?): List<String> =
        stringListString?.takeIf { it.isNotBlank() }?.let {
            gson.fromJson<List<String>>(it, object : TypeToken<List<String>>() {}.type)
        } ?: listOf()

    // Handle Double List
    @TypeConverter
    fun fromDoubleList(list: List<Double>): String? = gson.toJson(list)

    @TypeConverter
    fun toDoubleList(doubleListString: String?): List<Double> =
        doubleListString?.takeIf { it.isNotBlank() }?.let {
            val listType = object : TypeToken<List<Double>>() {}.type
            gson.fromJson<List<Double>>(it, listType)
        } ?: listOf()

}