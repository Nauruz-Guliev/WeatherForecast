package com.example.weatherapp.mainscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather_forecast.presentation.composables.homeScreen.WeatherHomeScreen
import com.example.weather_forecast.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.bottomNav.BottomNavigationItem
import com.example.weatherapp.bottomNav.MapScreen
import com.example.weatherapp.bottomNav.SettingsScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    onSearchButtonClicked: (String) -> Unit
) {
    NavHost(navController, startDestination = BottomNavigationItem.Home.screenRoute) {
        composable(BottomNavigationItem.Home.screenRoute) {
            WeatherHomeScreen(
                state = weatherViewModel.state,
                date = "Friday 27,\nJanuary 2023",
                onSearchButtonClicked = onSearchButtonClicked,
                onSeeMoreClicked = null,
            )
        }
        composable(BottomNavigationItem.Map.screenRoute) {
            MapScreen()
        }
        composable(BottomNavigationItem.Settings.screenRoute) {
            SettingsScreen()
        }
    }
}
