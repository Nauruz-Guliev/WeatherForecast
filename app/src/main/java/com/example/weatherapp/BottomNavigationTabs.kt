package com.example.weatherapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class BottomNavigationTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {

}