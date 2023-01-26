package com.example.weatherapp.data.remote.dto


import com.squareup.moshi.Json

data class ForecastResponse(
    val city: City,
    val cnt: Int, // 7
    val cod: String, // 200
    val list: List<WeatherData>,
    val message: Double // 6.8752018
) {
    data class City(
        val coord: Coord,
        val country: String, // RU
        val id: Int, // 551487
        val name: String, // Kazan’
        val population: Int, // 1104738
        val timezone: Int // 10800
    ) {
        data class Coord(
            val lat: Double, // 55.7887
            val lon: Double // 49.1221
        )
    }
    @Json(name = "")
    data class WeatherData(
        val clouds: Int, // 97
        val deg: Int, // 246
        val dt: Int, // 1674720000
        @Json(name = "feels_like")
        val feelsLike: FeelsLike,
        val gust: Double, // 14.36
        val humidity: Int, // 90
        val pop: Double, // 0.62
        val pressure: Int, // 1021
        val snow: Double?, // 0.96
        val speed: Double, // 6.24
        val sunrise: Int, // 1674708540
        val sunset: Int, // 1674738155
        val temp: Temp,
        val weather: List<Weather>
    ) {
        data class FeelsLike(
            val day: Double, // -10.04
            val eve: Double, // -9.36
            val morn: Double, // -13.77
            val night: Double // -9.41
        )

        data class Temp(
            val day: Double, // -3.56
            val eve: Double, // -2.99
            val max: Double, // -2.42
            val min: Double, // -8.69
            val morn: Double, // -6.83
            val night: Double // -3.15
        )

        data class Weather(
            val description: String, // light snow
            val icon: String, // 13d
            val id: Int, // 600
            val main: String // Snow
        )
    }
}