package com.example.common.utility

sealed class GeneralWeatherState<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : GeneralWeatherState<T>(data)
    class Error<T>(message: String, data: T? = null) : GeneralWeatherState<T>(data, message)
}
