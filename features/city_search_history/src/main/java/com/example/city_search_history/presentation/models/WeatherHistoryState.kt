package com.example.city_search_history.presentation.models

import com.example.city_search_history.domain.models.WeatherHistoryModel
import com.example.common.models.WeatherInfoModel
import kotlinx.coroutines.flow.Flow

data class WeatherHistoryState(
    val weatherHistory: Flow<List<WeatherHistoryModel>>? = null,
    val isEmpty: Boolean = true,
    val error: String? = null
)