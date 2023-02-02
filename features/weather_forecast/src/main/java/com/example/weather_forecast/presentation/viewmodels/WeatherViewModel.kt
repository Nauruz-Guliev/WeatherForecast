package com.example.weather_forecast.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.models.WeatherInfoModel
import com.example.weather_forecast.domain.location.LocationTracker
import com.example.weather_forecast.domain.repository.WeatherRepository
import com.example.common.utility.GeneralWeatherState
import com.example.weather_forecast.presentation.models.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())

    fun loadCurrentCityWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = "still here"
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = repository.getWeeklyCityWeatherInfo(
                    lon = location.longitude,
                    lat = location.latitude,
                )) {
                    is GeneralWeatherState.Success -> setStateSuccess(result.data)
                    is GeneralWeatherState.Error -> setStateError(result.message)
                }
            }
        }
    }

    fun loadWeatherForSpecifiedCity(cityName: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            when (val result = repository.getWeeklyCityWeatherInfo(cityName)) {
                is GeneralWeatherState.Success -> setStateSuccess(result.data)
                is GeneralWeatherState.Error -> setStateError(result.message)
            }
        }
    }

    private fun setStateSuccess(list: List<WeatherInfoModel>?) {
        state = state.copy(
            weatherInfoModel = list,
            isLoading = false
        )
    }

    private fun setStateError(errorMessage: String?) {
        state = state.copy(
            isLoading = false,
            error = errorMessage
        )
    }
}