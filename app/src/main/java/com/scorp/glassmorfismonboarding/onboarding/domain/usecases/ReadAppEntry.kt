package com.scorp.glassmorfismonboarding.onboarding.domain.usecases

import com.scorp.glassmorfismonboarding.onboarding.domain.manager.LocalUserManager

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke() = localUserManager.readAppEntry()
}