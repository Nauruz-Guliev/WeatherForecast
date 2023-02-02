package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.models.WeatherInfoModel
import com.example.common.theme.ui.Primary

@Composable
internal fun WeatherInfoArea(
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