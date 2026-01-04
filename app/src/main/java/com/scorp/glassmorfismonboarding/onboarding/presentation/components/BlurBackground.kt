package com.scorp.glassmorfismonboarding.onboarding.presentation.components

import android.graphics.RenderEffect
import android.graphics.Shader
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scorp.glassmorfismonboarding.ui.theme.AppTheme

@Composable
fun BlurBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF16164f))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.08f))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(25.dp, 25.dp)
                .graphicsLayer {
                    rotationZ = -25f
                    renderEffect = RenderEffect.createBlurEffect(40.dp.toPx(), 40.dp.toPx(), Shader.TileMode.CLAMP).asComposeRenderEffect()
                }
                .drawBehind {
                    drawOval(
                        size = Size(width = size.width, height = size.height/4),
                        topLeft = Offset(-size.width/3, size.height/2.5f),
                        color = Color(0xFFf1a6fa),
                        style = Stroke(width = 80f),
                    )
                }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer{
                    renderEffect = RenderEffect.createBlurEffect(200.dp.toPx(), 200.dp.toPx(), Shader.TileMode.CLAMP).asComposeRenderEffect()
                }
                .drawBehind {
                    drawCircle(
                        center = Offset(x = size.width/6, size.height),
                        color = Color(0xFF1f4470),
                    )
                }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer{
                    renderEffect = RenderEffect.createBlurEffect(200.dp.toPx(), 200.dp.toPx(), Shader.TileMode.CLAMP).asComposeRenderEffect()
                }
                .drawBehind {
                    drawCircle(
                        center = Offset(x = size.width, 0f),
                        color = Color(0xFF70E6FB),
                    )
                }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer{
                    renderEffect = RenderEffect.createBlurEffect(200.dp.toPx(), 200.dp.toPx(), Shader.TileMode.CLAMP).asComposeRenderEffect()
                }
                .drawBehind {
                    drawCircle(
                        center = Offset(x = size.width, size.height/2),
                        color = Color(0xFF552481),
                    )
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        BlurBackground()
    }
}