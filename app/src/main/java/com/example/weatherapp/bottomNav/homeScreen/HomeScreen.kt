package com.example.weatherapp.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.bottomNav.homeScreen.AppBar
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary


@Composable
fun WeatherHomeScreen(
    onSearchButtonClicked: (String) -> Unit) {
    Scaffold(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            AppBar(onSearchButtonClicked = onSearchButtonClicked)
        }
    ) {
        it.calculateBottomPadding()
    }
}


@Composable
fun WeatherInfoArea() {

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen {

    }
}
