package com.example.weatherapp.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.weatherapp.R
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.SearchHistory,
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
            androidx.compose.material.BottomNavigation(
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
