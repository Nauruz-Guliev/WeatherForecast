package com.example.weather_forecast.data.mappers

import com.example.common.mappers.GeneralMapper
import com.example.common.models.WeatherInfoModel
import com.example.weather_forecast.data.remote.dto.ForecastResponse
import java.util.*

object WeatherMapper : GeneralMapper<ForecastResponse, List<WeatherInfoModel>> {

    override fun toModel(model: ForecastResponse): List<WeatherInfoModel> {
        val weatherInfoModelList = mutableListOf<WeatherInfoModel>()
        for (i in 0 until model.cnt) {
            val singleDayForecast = WeatherInfoModel(
                cityName = model.city.name,
                day = model.list[i].dt,
                weatherDescription = model.list[i].weather[0].description,
                iconId = model.list[i].weather[0].icon,
                temperatureMorning = model.list[i].temp.morn,
                temperatureDay = model.list[i].temp.day,
                temperatureEvening = model.list[i].temp.eve,
                humidity = model.list[i].humidity,
                windSpeed = model.list[i].speed,
                pressure = model.list[i].pressure,
                sunrise = model.list[i].sunrise,
                sunset = model.list[i].sunset,
                searchDate = Calendar.getInstance().time
            )
            weatherInfoModelList.add(singleDayForecast)
        }
        return weatherInfoModelList
    }

    override fun fromModel(model: List<WeatherInfoModel>) = null
}