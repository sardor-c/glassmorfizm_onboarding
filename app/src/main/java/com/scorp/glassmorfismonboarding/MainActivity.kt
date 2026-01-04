package com.scorp.glassmorfismonboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import com.scorp.glassmorfismonboarding.onboarding.presentation.OnBoardingScreen
import com.scorp.glassmorfismonboarding.onboarding.presentation.components.BlurBackground
import com.scorp.glassmorfismonboarding.onboarding.presentation.components.OnBoardingCard
import com.scorp.glassmorfismonboarding.ui.navigation.AppNavGraph
import com.scorp.glassmorfismonboarding.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                AppNavGraph(startDestination = viewModel.startDestination.value)
            }
        }
    }
}
