package com.example.city_search_history.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.city_search_history.data.dao.WeatherForecastDao
import com.example.city_search_history.data.entity.WeatherForecastEntity
import com.example.city_search_history.data.typeConverters.DateConverter

@Database(
    version = 1,
    entities = arrayOf(WeatherForecastEntity::class, //todo image entity
         ),
    exportSchema = true
)
@TypeConverters(DateConverter::class)
abstract class WeatherHistoryDatabase : RoomDatabase() {
    abstract fun weatherForecastDao(): WeatherForecastDao
}