package com.example.city_search_history.di

import android.content.Context
import androidx.room.Room
import com.example.city_search_history.data.WeatherHistoryDatabase
import com.example.city_search_history.data.dao.WeatherHistoryDao import com.example.common.utility.convert
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

private const val DB_NAME = "WEATHER_DATABASE"

@Module
@InstallIn(SingletonComponent::class)
class WeatherDatabaseModule {

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
    fun provideWeatherForecastDao(weatherHistoryDatabase: WeatherHistoryDatabase): WeatherHistoryDao {
        return weatherHistoryDatabase.weatherForecastDao()
    }

    @Singleton
    @Provides
    fun provideDispatcher() = Dispatchers.IO
}