package com.example.weather_forecast.di

import com.example.weather_forecast.data.location.LocationTrackerImpl
import com.example.weather_forecast.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(locationTracker: LocationTrackerImpl): LocationTracker
}