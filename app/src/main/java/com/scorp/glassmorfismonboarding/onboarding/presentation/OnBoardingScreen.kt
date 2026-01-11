package com.scorp.glassmorfismonboarding.onboarding.presentation

import androidx.activity.compose.LocalActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.scorp.glassmorfismonboarding.onboarding.domain.model.pages
import com.scorp.glassmorfismonboarding.onboarding.presentation.components.BlurBackground
import com.scorp.glassmorfismonboarding.onboarding.presentation.components.ButtonActions
import com.scorp.glassmorfismonboarding.onboarding.presentation.components.OnBoardingCard

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, viewModel: OnboardingViewModel) {
    val activity = LocalActivity.current
    var currentPage by remember { mutableIntStateOf(0) }
    Box {
        BlurBackground(state = currentPage+1)
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPage == 0) {
                    IconButton(
                        onClick = {
                            activity?.finish()
                        }
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Icon(
                                Icons.Filled.Close,
                                null,
                                tint = Color.Black,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(15.dp)
                            )
                        }
                    }
                } else {
                    IconButton(
                        onClick = {
                            currentPage -= 1
                        }
                    ) {
                        Icon(Icons.Default.ArrowBack, null, tint = Color.White)
                    }
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(Icons.Default.Favorite, null, tint = Color.White)
                }
            }
            Spacer(Modifier.height(30.dp))
            AnimatedContent(
                modifier = Modifier
                    .size(280.dp)
                    .align(Alignment.CenterHorizontally),
                targetState = currentPage,
                transitionSpec = {
                    (fadeIn() + scaleIn()).togetherWith(fadeOut() + scaleOut())
                }
            ) {page->
                Image(
                    painterResource(pages[page].image),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(CircleShape)

                )
            }
            Spacer(Modifier.weight(1f))
            OnBoardingCard(
                page = pages[currentPage],
                buttonActions = ButtonActions(
                    next = { currentPage += 1 },
                    skip = if (currentPage == 2) null else ({
                        viewModel.saveAppEntry()
                    }),
                    getStarted = if (currentPage == 2) ({
                        viewModel.saveAppEntry()
                    }) else null
                )
            )
            Spacer(Modifier.weight(0.5f))
        }
    }
}

