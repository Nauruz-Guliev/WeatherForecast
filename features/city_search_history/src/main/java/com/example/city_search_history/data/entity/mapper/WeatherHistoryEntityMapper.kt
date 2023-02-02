package com.example.city_search_history.data.entity.mapper

import com.example.city_search_history.data.entity.WeatherHistoryEntity
import com.example.city_search_history.domain.models.WeatherHistoryModel
import com.example.common.mappers.GeneralMapper

object WeatherHistoryEntityMapper : GeneralMapper<WeatherHistoryEntity, WeatherHistoryModel> {

    override fun toModel(model: WeatherHistoryEntity) = WeatherHistoryModel(
        cityName = model.cityName,
        day = model.day,
        weatherDescription = model.weatherDescription,
        temperature = model.temperature,
        sunrise = model.sunrise,
        sunset = model.sunset,
        dateOfSearch = model.dateOfSearch,
        iconId = model.iconId,
    )

    override fun fromModel(model: WeatherHistoryModel) = WeatherHistoryEntity(
        id = 0,
        cityName = model.cityName,
        day = model.day,
        weatherDescription = model.weatherDescription,
        iconId = model.iconId,
        temperature = model.temperature,
        sunrise = model.sunrise,
        sunset = model.sunset,
        dateOfSearch = model.dateOfSearch
    )

}