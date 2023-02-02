package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.models.WeatherInfoModel
import com.example.common.theme.ui.Primary
import com.example.common.theme.ui.Secondary


@Composable
internal fun DetailsButtonSection(
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