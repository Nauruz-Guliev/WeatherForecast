package com.example.weatherapp.mainscreen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather_forecast.presentation.composables.homeScreen.WeatherHomeScreen
import com.example.weather_forecast.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.bottomNav.BottomNavigationItem
import com.example.weatherapp.bottomNav.MapScreen
import com.example.weatherapp.bottomNav.SettingsScreen
import java.sql.Time

@Composable
fun NavigationGraph(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    onSearchButtonClicked: (String) -> Unit
) {
    //todo fix date, currently taking first from the list
    NavHost(navController, startDestination = BottomNavigationItem.Home.screenRoute) {
        composable(BottomNavigationItem.Home.screenRoute) {
            Log.d("RESULT_FROM_API", weatherViewModel.state.weatherInfo.toString())
            WeatherHomeScreen(
                state = weatherViewModel.state,
                date = weatherViewModel.state.weatherInfo?.get(0)?.day ?: System.currentTimeMillis(),
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
