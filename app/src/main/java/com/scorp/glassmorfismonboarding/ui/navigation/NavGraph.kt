package com.scorp.glassmorfismonboarding.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scorp.glassmorfismonboarding.onboarding.presentation.OnBoardingScreen
import com.scorp.glassmorfismonboarding.onboarding.presentation.OnboardingViewModel


@Composable
fun AppNavGraph(startDestination: String?, modifier: Modifier = Modifier) {
   if (startDestination == null) {
      Box(modifier = Modifier
         .fillMaxSize()
         .background(MaterialTheme.colorScheme.background))
   } else {
      NavHost(
         modifier = modifier,
         navController = rememberNavController(),
         startDestination = startDestination
      ) {
         composable(Route.OnBoarding.route) {
            val viewModel: OnboardingViewModel = hiltViewModel()
            OnBoardingScreen(viewModel = viewModel)
         }

         composable(Route.App.route) {
            Box(
               modifier = Modifier.fillMaxSize(),
               contentAlignment = Alignment.Center
            ) {
               Text("You're Welcome!")
            }
         }
      }
   }
}