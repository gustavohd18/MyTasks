package com.example.mytasks.business.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytasks.business.database.login.User
import com.example.mytasks.business.database.login.UserDao
import com.example.mytasks.business.database.task.Task
import com.example.mytasks.business.database.task.TaskDao

@Database(entities = [User::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}
