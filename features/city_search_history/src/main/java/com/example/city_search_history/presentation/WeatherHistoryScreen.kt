package com.example.city_search_history.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.ui.components.AppBar
import com.example.common.models.WeatherInfoModel
import com.example.common.ui.theme.ui.Primary
import com.google.accompanist.insets.ui.Scaffold
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SearchHistoryScreen(onSearchButtonClicked: ((String) -> Unit)) {
    Scaffold(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            AppBar(onSearchButtonClicked = onSearchButtonClicked)
        },
        content = { innerPadding ->
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn() {
                    items(
                        createDummyWeatherInfo()
                    ) { data ->
                        WeatherInfoItem(weatherInfoModel = data)
                    }
                }
            }
            innerPadding.calculateBottomPadding()
        }
    )
}

@Composable
fun WeatherInfoItem(weatherInfoModel: WeatherInfoModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row() {
            Column(modifier = Modifier.padding(16.dp).weight(1.0f)) {
                Text(
                    text = weatherInfoModel.cityName,
                    fontSize = 20.sp
                )
                Text(
                    text = SimpleDateFormat("dd MMMM", Locale.US).format(weatherInfoModel.day)
                )
            }
            Column(modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp)) {
                Text(
                    text = weatherInfoModel.temperatureDay.toString(),
                    fontSize = 24.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewWindow() {
    SearchHistoryScreen(onSearchButtonClicked = ::clicked)
}

private fun createDummyWeatherInfo(): List<WeatherInfoModel> {
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

private fun clicked(s: String) {

}