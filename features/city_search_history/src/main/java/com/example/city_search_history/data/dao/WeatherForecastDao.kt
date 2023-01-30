package com.example.city_search_history.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.city_search_history.data.entity.WeatherForecastEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherForecastDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(forecast: WeatherForecastEntity)

    @Query("SELECT * FROM weather_forecast")
    fun getAll() : Flow<List<WeatherForecastEntity>>
}