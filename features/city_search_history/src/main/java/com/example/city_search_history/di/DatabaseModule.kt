package com.example.city_search_history.di

import android.content.Context
import androidx.room.Room
import com.example.city_search_history.data.WeatherHistoryDatabase
import com.example.city_search_history.data.dao.WeatherForecastDao
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

private const val DB_NAME = "WEATHER_DATABASE"

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideWeatherDatabase(@ApplicationContext context: Context): WeatherHistoryDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = WeatherHistoryDatabase::class.java,
            name = DB_NAME,
        ).build()
    }

    @Singleton
    @Provides
    fun provideWeatherForecastDao(weatherHistoryDatabase: WeatherHistoryDatabase): WeatherForecastDao {
        return weatherHistoryDatabase.weatherForecastDao()
    }
}