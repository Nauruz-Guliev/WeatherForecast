package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.models.WeatherInfoModel
import com.example.common.ui.theme.ui.Primary
import java.text.SimpleDateFormat
import java.util.*


@Composable
internal fun WeatherInfoItem(weatherInfoModel: WeatherInfoModel) {
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