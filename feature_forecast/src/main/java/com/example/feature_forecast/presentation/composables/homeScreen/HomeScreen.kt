package com.example.feature_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_forecast.domain.WeatherInfo
import com.example.feature_forecast.presentation.models.WeatherState
import com.example.weatherapp.theme.ui.FontColor
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary
import com.google.accompanist.insets.ui.Scaffold
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun WeatherHomeScreen(
    state: WeatherState,
    date: String,
    onSearchButtonClicked: ((String) -> Unit)?,
    onSeeMoreClicked: ((WeatherInfo) -> Unit)?
) {
    Scaffold(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            AppBar(onSearchButtonClicked = onSearchButtonClicked)
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                WeatherInfoArea(
                    date = date,
                    weatherInfo = state.weatherInfo!!.get(0),
                    onSeeMoreClicked
                )
            }
        },
    )
}

@Composable
private fun WeatherInfoArea(
    date: String,
    weatherInfo: WeatherInfo,
    onSeeMoreClicked: ((WeatherInfo) -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
    ) {
        DateSection(date = date)
        TemperatureSection(weatherInfo = weatherInfo)
        SunAppearanceSection(weatherInfo = weatherInfo)
        SecondaryWeatherInfoSection(weatherInfo = weatherInfo)
        DetailsButtonSection(onSeeMoreClicked = onSeeMoreClicked, weatherInfo = weatherInfo)
    }
}

@Composable
private fun DetailsButtonSection(
    onSeeMoreClicked: ((WeatherInfo) -> Unit)?,
    weatherInfo: WeatherInfo
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        TextButton(
            onClick = { onSeeMoreClicked?.invoke(weatherInfo) },
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
private fun SecondaryWeatherInfoSection(weatherInfo: WeatherInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp,
                )
            )
    ) {
        val columnCommonModifier = Modifier
            .weight(1.0f)
            .height(48.dp)
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfo.windSpeed.toString() + "km/h",
            secondaryText = "Wind",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfo.humidity.toString() + "%",
            secondaryText = "Humidity",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfo.temperatureEvening.toString() + "℃",
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
            fontSize = 16.sp
        )
        Text(
            modifier = modifier.padding(2.dp),
            text = secondaryText,
            color = Color.Gray
        )
    }
}

@Composable
private fun SunAppearanceSection(weatherInfo: WeatherInfo) {
    Row(
        Modifier
            .height(IntrinsicSize.Min) //intrinsic measurements
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
            ).format(weatherInfo.sunrise),
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
            text = "sunset: " + SimpleDateFormat("hh:mm:ss", Locale.US).format(weatherInfo.sunrise),
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
private fun TemperatureSection(weatherInfo: WeatherInfo) {
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
                text = weatherInfo.temperatureDay.toString() + "℃",
                fontSize = 48.sp,
                color = FontColor
            )
            Text(
                text = weatherInfo.cityName,
                fontSize = 20.sp,
                color = FontColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWindow() {
    val state = WeatherState(isLoading = false, weatherInfo = createDummyWeatherInfo())
    WeatherHomeScreen(
        state = state,
        date = "Friday 27,\nJanuary 2023",
        onSearchButtonClicked = null,
        onSeeMoreClicked = null,
    )
}

private fun createDummyWeatherInfo(): List<WeatherInfo> {
    val list = mutableListOf<WeatherInfo>()
    for (i in 0 until 7) {
        list.add(
            WeatherInfo(
                cityName = "Russia, Kazan",
                day = 1231241,
                weatherDescription = "Sunny",
                iconId = "10d",
                temperatureMorning = 12.0,
                temperatureDay = 12.4,
                temperatureEvening = 13.0,
                humidity = 12,
                windSpeed = 24.0,
                pressure = 12,
                sunset = 124124,
                sunrise = 124124,
            )
        )
    }
    return list
}


