package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.ui.components.AppBar
import com.example.common.models.WeatherInfoModel
import com.example.common.ui.theme.ui.FontColor
import com.example.common.ui.theme.ui.Primary
import com.example.common.ui.theme.ui.Secondary
import com.example.weather_forecast.presentation.models.WeatherState


import com.google.accompanist.insets.ui.Scaffold
import java.text.SimpleDateFormat
import java.util.*



@Composable
fun WeatherHomeScreen(
    state: WeatherState,
    onSearchButtonClicked: ((String) -> Unit)?,
    onSeeMoreClicked: ((WeatherInfoModel) -> Unit)?
) {
    Scaffold(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            AppBar(onSearchButtonClicked = onSearchButtonClicked)
        },
        content = { innerPadding ->
            if (state.weatherInfoModel != null) {
                Box(modifier = Modifier.padding(innerPadding)) {
                    WeatherInfoArea(
                        date = SimpleDateFormat(
                            "EEEE, dd \nMMMM",
                            Locale.getDefault()
                        ).format(state.weatherInfoModel[0].day),
                        weatherInfoModel = state.weatherInfoModel,
                        onSeeMoreClicked
                    )
                }
            } else if (state.error != null) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = state.error,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        },
    )
}





@Preview(showBackground = true)
@Composable
fun PreviewWindow() {
    val state = WeatherState(isLoading = false, weatherInfoModel = createDummyWeatherInfo())
    WeatherHomeScreen(
        state = state,
        onSearchButtonClicked = null,
        onSeeMoreClicked = null,
    )
}

fun createDummyWeatherInfo(): List<WeatherInfoModel> {
    val list = mutableListOf<WeatherInfoModel>()
    for (i in 0 until 7) {
        list.add(
            WeatherInfoModel(
                cityName = "Russia, Kazan",
                day = "1674${i}92089610".toLong(),
                weatherDescription = "Sunny",
                iconId = "10d",
                temperatureMorning = 12.0,
                temperatureDay = "${
                    ((-20..14).random().toDouble() % 14).toInt()
                }.${(0..99).random()}".toDouble(),
                temperatureEvening = 13.0,
                humidity = 12,
                windSpeed = 24.0,
                pressure = 12,
                sunset = "167492${(0..10).random()}214117".toLong(),
                sunrise = "167492${(0..10).random()}083690".toLong(),
                searchDate = Calendar.getInstance().time
            )
        )
    }
    return list
}


