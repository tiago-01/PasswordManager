package com.ipca.passwordmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AppRepository

    val allApps: LiveData<List<App>>

    init {
        val appsDao = AppRoomDatabase.getDatabase(application, viewModelScope).appDao()
        repository = AppRepository(appsDao)
        allApps = repository.allApps
    }

    fun insert(app: App) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(app)
    }
    fun delete(app: App) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(app)
    }
}
