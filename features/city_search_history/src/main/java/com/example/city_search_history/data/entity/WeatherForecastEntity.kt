package com.example.city_search_history.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "weather_forecast")
class WeatherForecastEntity(
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
    @ColumnInfo(name = "temperature_morning")
    val temperatureMorning: Double,
    @ColumnInfo(name = "temperature_day")
    val temperatureDay: Double,
    @ColumnInfo(name = "temperature_evening")
    val temperatureEvening: Double,
    val humidity: Long,
    @ColumnInfo(name = "wind_speed")
    val windSpeed: Double,
    val pressure: Long,
    val sunrise: Long,
    val sunset: Long,

    @ColumnInfo(name = "date_of_search")
    val dateOfSearch: Date
)