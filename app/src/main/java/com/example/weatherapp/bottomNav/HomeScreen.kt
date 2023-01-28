package com.example.weatherapp.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary


@Composable
fun WeatherHomeScreen(
    onSearchButtonClicked: (String) -> Unit,
) {
    Scaffold(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(8.dp),
                elevation = 4.dp
            ) {
                AppBar(onSearchButtonClicked)
            }
        }
    ) {
        it.calculateBottomPadding()
    }
}

@Composable
private fun AppBar(onSearchButtonClicked: (String) -> Unit) {
    var input by rememberSaveable { mutableStateOf("") }
    TopAppBar(
        backgroundColor = Primary,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        BasicTextField(
            modifier = Modifier
                .padding(8.dp)
                .weight(1.0f),
            value = input,
            onValueChange = { input = it },
            textStyle = TextStyle(),
            decorationBox = { innerTextField ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    if (input.isEmpty()) {
                        Text(
                            text = "What city?",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }
                innerTextField()
            }
        )
        SearchButton(onSearchButtonClicked, input)
    }
}

@Composable
private fun SearchButton(onSearchButtonClicked: (String) -> Unit, cityName: String) {
    IconButton(
        modifier = Modifier
            .size(56.dp)
            .padding(8.dp)
            .background(
                color = Secondary,
                shape = RoundedCornerShape(16.dp)
            ),
        content = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Search",
                tint = Primary
            )
        },
        onClick = { onSearchButtonClicked(cityName) },
    )
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen {

    }
}
