package com.scorp.glassmorfismonboarding.ui.navigation

sealed class Route(val route: String) {
    object OnBoarding: Route("onboarding")
    object App: Route("app")
}