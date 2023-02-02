package com.example.city_search_history.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.city_search_history.domain.`use-cases`.AddWeatherForecastUseCase
import com.example.city_search_history.domain.`use-cases`.GetWeatherHistoryListUseCase
import com.example.city_search_history.presentation.mappers.WeatherInfoMapper
import com.example.city_search_history.presentation.models.WeatherHistoryState
import com.example.common.models.WeatherInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherHistoryViewModel @Inject constructor(
    private val addWeatherForecastUseCase: AddWeatherForecastUseCase,
    private val getWeatherHistoryListUseCase: GetWeatherHistoryListUseCase
) : ViewModel() {
    var state by mutableStateOf(WeatherHistoryState())
        private set

    fun loadWeatherHistoryList() {
        viewModelScope.launch {
            try {
                val weatherHistory = getWeatherHistoryListUseCase()
                state = if (weatherHistory.count() != 0) {
                    state.copy(
                        weatherHistory = weatherHistory
                    )
                } else {
                    state.copy(
                        isEmpty = true
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    //todo extract to resources
                    error = "Couldn't load data due to: ${e.message}"
                )
            }
        }
    }

    fun addWeatherInfo(weatherInfoModel: WeatherInfoModel) {
        viewModelScope.launch {
            // user doesn't have to know(not yet at least) if an item was added to the repository or not
            // no state is introduced here
            addWeatherForecastUseCase(
                weatherHistoryModel = WeatherInfoMapper.toModel(weatherInfoModel)
            )
        }
    }

}


