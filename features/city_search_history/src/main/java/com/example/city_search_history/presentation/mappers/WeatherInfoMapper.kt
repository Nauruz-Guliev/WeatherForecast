package com.example.city_search_history.presentation.mappers

import com.example.city_search_history.domain.models.WeatherHistoryModel
import com.example.common.mappers.GeneralMapper
import com.example.common.models.WeatherInfoModel

object WeatherInfoMapper : GeneralMapper<WeatherInfoModel, WeatherHistoryModel> {
    override fun toModel(model: WeatherInfoModel) =
        WeatherHistoryModel(
            id = 0,
            cityName = model.cityName,
            day = model.day,
            weatherDescription = model.weatherDescription,
            iconId = model.iconId,
            temperature = model.temperatureDay,
            sunrise = model.sunrise,
            sunset = model.sunset,
            dateOfSearch = model.searchDate
        )


    override fun fromModel(model: WeatherHistoryModel): WeatherInfoModel? = null
}