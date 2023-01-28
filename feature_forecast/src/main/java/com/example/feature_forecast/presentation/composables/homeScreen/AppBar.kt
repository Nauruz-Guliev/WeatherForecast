package com.example.feature_forecast.presentation.composables.homeScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_forecast.R
import com.example.weatherapp.theme.ui.Primary
import com.example.weatherapp.theme.ui.Secondary


@Composable
fun AppBar(onSearchButtonClicked: ((String) -> Unit)?) {
    var input by rememberSaveable { mutableStateOf("") }
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()

            .padding(8.dp),
        elevation = 4.dp
    ) {
        TopAppBar(
            backgroundColor = Primary,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Spacer(modifier = Modifier.width(4.dp))
            Row(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .height(40.dp)
                    .weight(1.0f)
            ) {
                BasicTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    value = input,
                    onValueChange = { input = it },
                    textStyle = TextStyle(),
                    decorationBox = { innerTextField ->
                        Row {
                            if (input.isEmpty()) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .wrapContentHeight(align = Alignment.CenterVertically),
                                    text = "What city?",
                                    textAlign = TextAlign.Left,
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        innerTextField()
                    }
                )

            }
            Spacer(modifier = Modifier.width(8.dp))
            SearchButton(onSearchButtonClicked, input)
        }
    }
}

@Composable
private fun SearchButton(onSearchButtonClicked: ((String) -> Unit)?, cityName: String) {
    IconButton(
        modifier = Modifier
            .padding(0.dp)
            .size(48.dp)
            .background(
                color = Secondary,
                shape = RoundedCornerShape(16.dp)
            ),
        content = {
            Icon(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp),
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Search",
                tint = Primary
            )
        },
        onClick = { onSearchButtonClicked?.invoke(cityName) },
    )

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    AppBar {

    }
}
