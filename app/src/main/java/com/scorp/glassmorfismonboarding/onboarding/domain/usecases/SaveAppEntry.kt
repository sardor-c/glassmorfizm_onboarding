package com.scorp.glassmorfismonboarding.onboarding.domain.usecases

import com.scorp.glassmorfismonboarding.onboarding.domain.manager.LocalUserManager
import jakarta.inject.Inject

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() = localUserManager.saveAppEntry()
}