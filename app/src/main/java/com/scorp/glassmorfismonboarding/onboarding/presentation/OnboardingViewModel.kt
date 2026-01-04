package com.scorp.glassmorfismonboarding.onboarding.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scorp.glassmorfismonboarding.onboarding.domain.usecases.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val saveAppEntryUseCase: SaveAppEntry
): ViewModel() {

    fun saveAppEntry(){
        viewModelScope.launch {
            Log.d("TAG", "OnbViewmodel: save")
            saveAppEntryUseCase()
        }
    }


}