package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.models.WeatherInfoModel
import com.example.common.ui.theme.ui.FontColor
import com.example.common.ui.theme.ui.Primary
import java.text.SimpleDateFormat
import java.util.*

@Composable
internal fun SunAppearanceSection(weatherInfoModel: WeatherInfoModel) {
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