package com.scorp.glassmorfismonboarding.onboarding.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scorp.glassmorfismonboarding.onboarding.domain.model.Page
import com.scorp.glassmorfismonboarding.onboarding.domain.model.pages


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnBoardingCard(
    page: Page,
    buttonActions: ButtonActions,
    modifier: Modifier = Modifier
) {

    val textTransitionSpecRight = (scaleIn() + fadeIn()).togetherWith(scaleOut() + fadeOut())

    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10))
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(10)
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.4f),
                        Color.White.copy(alpha = 0.1f)
                    )
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
        ) {
            AnimatedContent(page.title, transitionSpec = { textTransitionSpecRight }) {
                Text(
                    text = page.title,
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedContent(page.description, transitionSpec = { textTransitionSpecRight }) {
                Text(
                    text = page.description,
                    color = Color(0xFFa6a7c8),
                    lineHeight = 20.sp,
                    fontSize = 14.sp
                )
            }
            buttonActions.skip?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = buttonActions.skip
                    ) {
                        Text("Skip", color = Color(0xFFa8b3d2))
                    }
                    Button(
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFe6e7ef),
                            contentColor = Color.Black
                        ),
                        onClick = buttonActions.next!!
                    ) {
                        Text("Next")
                    }
                }
            }
            buttonActions.getStarted?.let {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    shape = RoundedCornerShape(30),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFe6e7ef),
                        contentColor = Color.Black
                    ),
                    onClick = buttonActions.getStarted
                ) {
                    Text("Get Started")
                }
            }
            Spacer(Modifier.height(10.dp))
            PageIndicator(
                pagesCount = 3,
                selectedPage = pages.indexOf(page) + 1,
                indicatorSize = 7.dp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp)
            )
        }

    }
}

data class ButtonActions(
    val skip: (() -> Unit)? = null,
    val next: (() -> Unit)? = null,
    val getStarted: (() -> Unit)? = null
)
