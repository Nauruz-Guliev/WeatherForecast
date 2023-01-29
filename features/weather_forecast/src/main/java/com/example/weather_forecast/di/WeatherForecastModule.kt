package com.example.weather_forecast.di

import android.app.Application
import com.example.weather_forecast.data.remote.ApiKeyInterceptor
import com.example.weather_forecast.data.remote.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://api.openweathermap.org/"
@Module
@InstallIn(SingletonComponent::class)
object WeatherForecastModule {

    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient):WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideFusedLocationClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        apiKeyInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideApiKeyInterceptor() = ApiKeyInterceptor.getApiKeyInterceptor()


}