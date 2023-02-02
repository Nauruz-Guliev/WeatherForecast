package com.example.city_search_history.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "weather_forecast")
class WeatherHistoryEntity(
    @PrimaryKey
    val id: Int? = null,
    @ColumnInfo(name = "city_name")
    val cityName: String,
    val day: Long,
    @ColumnInfo(name = "weather_description")
    val weatherDescription: String,
    // todo create another table for icons (o2m)
    @ColumnInfo(name = "icon_id")
    val iconId: String,
    // temperature-day will be taken as default
    val temperature: Double,

    val sunrise: Long,
    val sunset: Long,

    @ColumnInfo(name = "date_of_search")
    val dateOfSearch: Date
)