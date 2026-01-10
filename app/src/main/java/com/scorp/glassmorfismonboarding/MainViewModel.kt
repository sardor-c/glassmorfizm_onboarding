package com.scorp.glassmorfismonboarding

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scorp.glassmorfismonboarding.onboarding.domain.usecases.ReadAppEntry
import com.scorp.glassmorfismonboarding.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
) : ViewModel() {
    private val _startDestination = mutableStateOf(Route.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    init {
        readAppEntry().onEach { entered ->
            if (entered) {
                _startDestination.value = Route.App.route
            } else {
                _startDestination.value = Route.OnBoarding.route
            }
            //delay(100)
        }.launchIn(viewModelScope)
    }
}