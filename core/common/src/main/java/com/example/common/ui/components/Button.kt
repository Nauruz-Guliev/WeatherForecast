package com.example.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.ui.theme.ui.Primary
import com.example.common.ui.theme.ui.Secondary
import com.example.common.ui.theme.ui.Shapes


@Composable
fun WfaSmallButton(
    onClick:() -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    text: String
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp,
                    end = 8.dp
                )
            )
            .clip(shape = Shapes.large)
    ) {
        Text(
            modifier = Modifier
                .background(color = Secondary, shape = RoundedCornerShape(16.dp))
                .padding(
                    paddingValues = PaddingValues(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                ),
            text = text,
            color = Primary,
            fontSize = 14.sp,
        )
    }
}