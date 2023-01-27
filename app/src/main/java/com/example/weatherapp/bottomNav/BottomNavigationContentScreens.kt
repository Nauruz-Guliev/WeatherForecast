package com.example.weatherapp.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.theme.ui.Primary

@Composable
fun HomeScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
            {
                TextField(
                    value = "What city?",
                    onValueChange = { },
                )

            }
        }
    }
}

@Composable
fun MapScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Map screen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Settings screen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    HomeScreen()
}

