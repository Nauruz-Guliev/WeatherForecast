package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.bottomNav.*
import com.example.weatherapp.theme.WeatherAppTheme
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary
import com.example.feature_forecast.presentation.composables.homeScreen.WeatherHomeScreen
import com.example.feature_forecast.presentation.composables.homeScreen.createDummyWeatherInfo
import com.example.feature_forecast.presentation.models.WeatherState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                WeatherHomeScreen(
                    state = WeatherState(
                        weatherInfo = createDummyWeatherInfo(),
                        isLoading = false,
                        error = null
                    ),
                    date = "Friday 27,\nJanuary 2023",
                    onSearchButtonClicked = null,
                    onSeeMoreClicked = null,
                )
            }
        }
    }
}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        it.calculateBottomPadding()
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Map,
        BottomNavigationItem.Settings,

        )
    Surface() {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .shadow(8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            BottomNavigation(
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
                backgroundColor = Primary,
                contentColor = Secondary
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(painterResource(id = item.icon), contentDescription = item.title)
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 12.sp
                            )
                        },
                        selectedContentColor = Secondary,
                        unselectedContentColor = Secondary.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.screenRoute,
                        onClick = {
                            navController.navigate(item.screenRoute) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItem.Home.screenRoute) {
        composable(BottomNavigationItem.Home.screenRoute) {

        }
        composable(BottomNavigationItem.Map.screenRoute) {
            MapScreen()
        }
        composable(BottomNavigationItem.Settings.screenRoute) {
            SettingsScreen()
        }
    }
}






@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    MainScreenView()
}