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
import com.example.common.components.AppBar
import com.example.common.models.WeatherInfoModel
import com.example.common.theme.ui.FontColor
import com.example.common.theme.ui.Primary
import com.example.common.theme.ui.Secondary
import com.example.weather_forecast.presentation.models.WeatherState


import com.google.accompanist.insets.ui.Scaffold
import java.text.SimpleDateFormat
import java.util.*



@Composable
fun WeatherHomeScreen(
    state: WeatherState,
    date: Long,
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




@Composable
private fun WeatherInfoArea(
    date: String,
    weatherInfoModel: List<WeatherInfoModel>,
    onSeeMoreClicked: ((WeatherInfoModel) -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
    ) {
        DateSection(date = date)
        TemperatureSection(weatherInfoModel = weatherInfoModel[0])
        SunAppearanceSection(weatherInfoModel = weatherInfoModel[0])
        SecondaryWeatherInfoSection(weatherInfoModel = weatherInfoModel[0])
        DetailsButtonSection(onSeeMoreClicked = onSeeMoreClicked, weatherInfoModel = weatherInfoModel[0])
        WeatherWeeklyList(weatherInfoModelItems = weatherInfoModel)
    }
}

@Composable
private fun WeatherWeeklyList(weatherInfoModelItems: List<WeatherInfoModel>) {
    LazyRow(
        modifier = Modifier.padding(
            paddingValues = PaddingValues(top = 24.dp)
        )
    ) {
        items(
            weatherInfoModelItems
        ) { data ->
            WeatherInfoItem(weatherInfoModel = data)
        }
    }
}

@Composable
private fun WeatherInfoItem(weatherInfoModel: WeatherInfoModel) {
    Card(
        backgroundColor = Primary,
        modifier = Modifier
            .padding(16.dp)
            .width(80.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        paddingValues = PaddingValues(
                            top = 8.dp
                        )
                    )
                    .fillMaxWidth(),
                text = SimpleDateFormat(
                    "EEEE",
                    Locale.US
                ).format(weatherInfoModel.day),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .padding(
                        paddingValues = PaddingValues(
                            top = 16.dp
                        )
                    )
                    .size(32.dp)
                    .background(color = Color.Yellow, shape = RoundedCornerShape(40.dp)),
            )
            Text(
                modifier = Modifier
                    .padding(
                        paddingValues = PaddingValues(
                            top = 8.dp,
                            bottom = 8.dp
                        )
                    )
                    .fillMaxWidth(),
                text = weatherInfoModel.temperatureDay.toString() + "℃",
                textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
private fun DetailsButtonSection(
    onSeeMoreClicked: ((WeatherInfoModel) -> Unit)?,
    weatherInfoModel: WeatherInfoModel
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        TextButton(
            onClick = { onSeeMoreClicked?.invoke(weatherInfoModel) },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .padding(
                    paddingValues = PaddingValues(
                        top = 16.dp,
                        end = 8.dp
                    )
                )
                .clip(shape = RoundedCornerShape(40.dp))
        ) {
            Text(
                modifier = Modifier
                    .background(color = Secondary, shape = RoundedCornerShape(16.dp))
                    .padding(
                        paddingValues = PaddingValues(
                            top = 8.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    ),
                text = "See details >",
                color = Primary,
                fontSize = 14.sp,
            )
        }
    }
}


@Composable
private fun SecondaryWeatherInfoSection(weatherInfoModel: WeatherInfoModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                paddingValues = PaddingValues(
                    top = 24.dp,
                )
            )
    ) {
        val columnCommonModifier = Modifier
            .weight(1.0f)
            .height(48.dp)
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.windSpeed.toString() + "km/h",
            secondaryText = "Wind",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.humidity.toString() + "%",
            secondaryText = "Humidity",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.temperatureEvening.toString() + "℃",
            secondaryText = "Feels like",
            modifier = columnCommonModifier
        )
    }

}


@Composable
private fun SecondaryWeatherInfoColumn(
    primaryText: String,
    secondaryText: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = primaryText,
            fontSize = 20.sp
        )
        Text(
            modifier = modifier.padding(2.dp),
            text = secondaryText,
            color = Color.Gray
        )
    }
}

@Composable
private fun SunAppearanceSection(weatherInfoModel: WeatherInfoModel) {
    Row(
        Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp
                )
            )
            .background(Primary)
    ) {

        Text(
            modifier = Modifier.weight(1.0f),
            text = "sunrise: " + SimpleDateFormat(
                "hh:mm:ss",
                Locale.US
            ).format(weatherInfoModel.sunrise),
            textAlign = TextAlign.Center,
            color = FontColor
        )

        Divider(
            color = FontColor,
            modifier = Modifier
                .fillMaxHeight()  //fill the max height
                .width(1.dp)
        )

        Text(
            modifier = Modifier.weight(1.0f),
            text = "sunset: " + SimpleDateFormat("hh:mm:ss", Locale.US).format(weatherInfoModel.sunset),
            textAlign = TextAlign.Center,
            color = FontColor
        )
    }
}

@Composable
private fun DateSection(date: String) {
    Row(
        modifier = Modifier
            .background(Primary)
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                )
            )
    ) {
        Text(
            text = date,
            fontSize = 20.sp,
        )
    }
}

@Composable
private fun TemperatureSection(weatherInfoModel: WeatherInfoModel) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .padding(
                    paddingValues =
                    PaddingValues(
                        top = 40.dp,
                        start = 40.dp,
                    )
                )
                .background(color = Color.Yellow, shape = RoundedCornerShape(64.dp))
        )
        Column(
            modifier = Modifier
                .padding(
                    paddingValues = PaddingValues(
                        top = 40.dp,
                        start = 16.dp
                    )
                )
                .weight(1.0f),

            ) {
            Text(
                text = weatherInfoModel.temperatureDay.toString() + "℃",
                fontSize = 48.sp,
                color = FontColor
            )
            Text(
                text = weatherInfoModel.cityName,
                fontSize = 20.sp,
                color = FontColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWindow() {
    val state = WeatherState(isLoading = false, weatherInfoModel = createDummyWeatherInfo())
    WeatherHomeScreen(
        state = state,
        date = System.currentTimeMillis(),
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
            )
        )
    }
    return list
}


