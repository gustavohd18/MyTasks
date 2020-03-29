package com.example.mytasks.business.database.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "priority") val priority: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "userEmail") val user: String,
    @ColumnInfo(name = "creation") val creation: String
)