package com.ipca.passwordmanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_table")
data class App(

    @PrimaryKey
    @ColumnInfo(name = "appname") val appname: String,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?
)