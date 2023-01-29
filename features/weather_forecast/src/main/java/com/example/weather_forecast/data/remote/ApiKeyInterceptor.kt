package com.example.weather_forecast.data.remote

import okhttp3.Interceptor

private const val API_KEY = "56fc6c6cb76c0864b4cd055080568268"
private const val API_KEY_QUERY = "appid"

object ApiKeyInterceptor {
    fun getApiKeyInterceptor() = Interceptor { chain ->
        val originalUrl = chain.request()
        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY)
            .build()
        chain.proceed(
            originalUrl.newBuilder().url(newUrl).build()
        )
    }
}