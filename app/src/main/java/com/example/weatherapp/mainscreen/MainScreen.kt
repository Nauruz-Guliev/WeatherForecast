package com.example.weatherapp.mainscreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_forecast.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.bottomNav.BottomNavigation


@Composable
fun MainScreenView(weatherViewModel: WeatherViewModel, onSearchButtonClicked: (String) -> Unit) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        it.calculateBottomPadding()
        NavigationGraph(
            navController = navController,
            weatherViewModel = weatherViewModel,
            onSearchButtonClicked = onSearchButtonClicked
        )
    }
}