package com.scorp.glassmorfismonboarding.onboarding.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    fun readAppEntry(): Flow<Boolean>
    suspend fun saveAppEntry()
}