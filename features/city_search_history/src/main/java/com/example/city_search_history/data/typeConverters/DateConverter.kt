package com.example.city_search_history.data.typeConverters

import androidx.room.TypeConverter
import java.util.*

object DateConverter {
    @TypeConverter
    fun toDate(dateLong: Long?) =
        dateLong?.let {
            Date(it)
        }

    @TypeConverter
    fun fromDate(date: Date?) = date?.time

}