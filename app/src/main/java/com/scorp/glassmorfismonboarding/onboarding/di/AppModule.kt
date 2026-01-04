package com.scorp.glassmorfismonboarding.onboarding.di

import android.app.Application
import com.scorp.glassmorfismonboarding.onboarding.data.manager.LocalUserManagerImpl
import com.scorp.glassmorfismonboarding.onboarding.domain.manager.LocalUserManager
import com.scorp.glassmorfismonboarding.onboarding.domain.usecases.ReadAppEntry
import com.scorp.glassmorfismonboarding.onboarding.domain.usecases.SaveAppEntry
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(context: Application): LocalUserManager {
        return LocalUserManagerImpl(context)
    }

    @Provides
    @Singleton
    fun provideReadAppEntryUserCase(localUserManager: LocalUserManager) =
        ReadAppEntry(localUserManager)

    @Provides
    @Singleton
    fun provideSaveAppEntryUseCase(localUserManager: LocalUserManager) =
        SaveAppEntry(localUserManager)
}