package com.example.weatherapp.bottomNav

import com.example.weatherapp.R

sealed class BottomNavigationItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home: BottomNavigationItem("Home", R.drawable.baseline_home_24, "home")
    object Map: BottomNavigationItem("Map", R.drawable.baseline_map_24, "map")
    object Settings: BottomNavigationItem("Settings", R.drawable.baseline_settings_24, "settings")
}
