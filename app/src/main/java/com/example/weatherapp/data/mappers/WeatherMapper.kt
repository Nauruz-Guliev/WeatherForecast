package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.remote.dto.ForecastResponse
import com.example.weatherapp.domain.WeatherInfo

object WeatherMapper {

    //todo write cleaner
    fun weatherDtoToListOfWeatherInfo(response: ForecastResponse): List<WeatherInfo> {
        val weatherInfoList = mutableListOf<WeatherInfo>()
        for (i in 0 until response.cnt) {
            val singleDayForecast = WeatherInfo(
                cityName = response.city.name,
                day = response.list[i].dt,
                weatherDescription = response.list[i].weather[0].description,
                iconId = response.list[i].weather[0].icon,
                temperatureMorning = response.list[i].temp.morn,
                temperatureDay = response.list[i].temp.day,
                temperatureEvening = response.list[i].temp.eve,
                humidity = response.list[i].humidity,
                windSpeed = response.list[i].speed,
                pressure = response.list[i].pressure,
                sunrise = response.list[i].sunrise,
                sunset = response.list[i].sunset
            )
            weatherInfoList.add(singleDayForecast)
        }
        return weatherInfoList
    }
}