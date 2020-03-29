package com.example.mytasks.business.database.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "password") val password: String?
)
