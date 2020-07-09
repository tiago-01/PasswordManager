package com.ipca.passwordmanager

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class AppRepository(private val appDao: AppDao) {



    val allApps: LiveData<List<App>> = appDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(app: App) {
        appDao.insert(app)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(app: App) {
        appDao.delete(app)
    }
}