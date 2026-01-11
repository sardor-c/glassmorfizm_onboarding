package com.scorp.glassmorfismonboarding.onboarding.presentation.components

import android.graphics.RenderEffect
import android.graphics.Shader
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scorp.glassmorfismonboarding.ui.theme.AppTheme

@Composable
fun BlurBackground(modifier: Modifier = Modifier, state: Int = 1) {
   val offsetFact by animateFloatAsState(
      targetValue = when (state) {
         1 -> 1f
         2 -> 2f
         3 -> 3f
         else -> 1f
      },
      animationSpec = tween(durationMillis = 1000)
   )
   val offsetFactReverse by animateFloatAsState(
      targetValue = when (state) {
         1 -> 3f
         2 -> 2f
         3 -> 1f
         else -> 3f
      },
      animationSpec = tween(durationMillis = 1000)
   )

   Box(
      modifier = modifier
         .fillMaxSize()
   ) {
      Box(
         modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16164f))
      )
      // shapes
      Box(
         modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
               renderEffect =
                  RenderEffect.createBlurEffect(
                     200.dp.toPx(),
                     200.dp.toPx(),
                     Shader.TileMode.CLAMP
                  )
                     .asComposeRenderEffect()
            }

            .drawBehind {

               drawCircle(
                  radius = size.width / 3f,
                  center = Offset(x = size.width / offsetFact, y = 0f),
                  color = Color(0xFF70E6FB),
               )
               drawCircle(
                  radius = size.width / 4f,
                  center = Offset(
                     x = size.width / offsetFactReverse,
                     y = size.height / offsetFactReverse
                  ),
                  color = Color(0xFF30EE43),
               )
               drawCircle(
                  center = Offset(x = size.width / offsetFact, size.height / offsetFact),
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
      BlurBackground(state = 1)
   }
}