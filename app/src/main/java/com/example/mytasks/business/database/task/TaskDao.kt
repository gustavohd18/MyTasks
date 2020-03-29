package com.example.mytasks.business.database.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM task where userEmail=:email")
    fun getAll(email: String): List<Task>

    @Query("SELECT * FROM task WHERE name like :name")
    fun findTask(name: String): Task

    @Insert
    fun insertTask(vararg tasks: Task)

    @Delete
    fun delete(task: Task)

    @Query("UPDATE task SET creation =:newDate WHERE name =:name")
    fun updateDate(name: String, newDate: String)

}