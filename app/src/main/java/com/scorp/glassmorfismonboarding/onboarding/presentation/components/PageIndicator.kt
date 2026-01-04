package com.scorp.glassmorfismonboarding.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.scorp.glassmorfismonboarding.ui.theme.AppTheme

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pagesCount: Int,
    selectedPage: Int,
    indicatorSize: Dp = 10.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (i in 1..pagesCount) {
            Box(
                modifier = Modifier
                    .size(indicatorSize)
                    .clip(shape = CircleShape)
                    .background(if (i == selectedPage) Color.White else Color.Gray)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            PageIndicator(
                pagesCount = 3,
                selectedPage = 2
            )
        }
    }
}