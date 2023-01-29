package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.weather_forecast.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.mainscreen.MainScreenView
import com.example.weatherapp.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val launcher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        weatherViewModel.loadWeatherForSpecifiedCity("Kazan")
    }

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
        setContent {
            WeatherAppTheme {
                MainScreenView(
                    weatherViewModel = weatherViewModel,
                    onSearchButtonClicked = ::onSearchButtonClicked
                )
            }
        }
    }

    private fun onSearchButtonClicked(cityName: String) {
        val state = weatherViewModel.state
        weatherViewModel.loadWeatherForSpecifiedCity(cityName)
        Log.d(
            "RESULT",
            state.weatherInfo.toString() + " " + cityName + " " + state.error + " " + state.isLoading
        )
    }
}
