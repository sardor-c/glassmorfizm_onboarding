package com.scorp.glassmorfismonboarding.onboarding.data.manager

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.scorp.glassmorfismonboarding.onboarding.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImpl @Inject constructor(
    private val context: Context
) : LocalUserManager {
    override fun readAppEntry(): Flow<Boolean> {
        Log.d("TAG", "readAppEntry: reading...")
        return context.dataStore.data.map {
            val res = it[PrefKeys.appEntry] ?: false
            Log.d("TAG", "readAppEntry: response = $res")
            res
        }
    }

    override suspend fun saveAppEntry() {
        Log.d("TAG", "LocalUserManager: save")
        context.dataStore.edit {
            it[PrefKeys.appEntry] = true
        }
    }
}

private val Context.dataStore by preferencesDataStore(name = "UserSetting")

object PrefKeys {
    val appEntry = booleanPreferencesKey(name = "appEntry")
}


