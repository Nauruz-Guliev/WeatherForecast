package com.example.weatherapp.mainscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.city_search_history.presentation.SearchHistoryScreen
import com.example.map.presentation.MapScreen
import com.example.settings.presentation.SettingsScreen
import com.example.weather_forecast.presentation.composables.homeScreen.WeatherHomeScreen
import com.example.weather_forecast.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.bottomNav.BottomNavigationItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    onSearchButtonClicked: (String) -> Unit
) {
    //todo fix date, currently taking first from the list
    NavHost(navController, startDestination = BottomNavigationItem.Home.screenRoute) {
        composable(BottomNavigationItem.Home.screenRoute) {
            WeatherHomeScreen(
                state = weatherViewModel.state,
                date = weatherViewModel.state.weatherInfo?.get(0)?.day ?: System.currentTimeMillis(),
                onSearchButtonClicked = onSearchButtonClicked,
                onSeeMoreClicked = null,
            )
        }
        composable(BottomNavigationItem.SearchHistory.screenRoute) {
            SearchHistoryScreen(onSearchButtonClicked)
        }
        composable(BottomNavigationItem.Map.screenRoute) {
            MapScreen()
        }
        composable(BottomNavigationItem.Settings.screenRoute) {
            SettingsScreen()
        }

    }
}
