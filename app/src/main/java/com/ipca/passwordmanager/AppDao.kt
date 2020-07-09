package com.ipca.passwordmanager

import androidx.lifecycle.LiveData;
import androidx.room.*

@Dao
interface AppDao {



    @Query("SELECT * from app_table")
    fun getAll(): LiveData<List<App>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(app: App)

    @Delete fun delete(app: App)
}