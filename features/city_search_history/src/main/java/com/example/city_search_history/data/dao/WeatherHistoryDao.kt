package com.example.city_search_history.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.city_search_history.data.entity.WeatherHistoryEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherHistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(forecast: WeatherHistoryEntity)

    @Query("SELECT * FROM weather_forecast")
    fun getAll() : Flow<List<WeatherHistoryEntity>>

}