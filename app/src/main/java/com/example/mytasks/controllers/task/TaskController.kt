package com.example.mytasks.controllers.task

import android.content.Context

import androidx.room.Room
import com.example.mytasks.business.database.AppDatabase
import com.example.mytasks.business.database.task.Task

import java.util.*

class TaskController (context:Context) {

    private val dataBase =  Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "tasks"
    ).allowMainThreadQueries().build() // verificar pois a docu diz pra nao usar allow problema concorrencia



    fun create(name: String, description: String, userName:String, type: String, date: String, priority: String) : Boolean {

        if(name == "" || description == "" || userName == "" ||  type == "" || priority == "" || date == "") {
            return false
        }

        val id = Random().nextInt(1000)

       val task =  Task(id, name, description,priority,type,userName,date)
        dataBase.taskDao().insertTask(task)

        return true
    }

    fun getAll(userEmail: String): List<Task> {
       return  dataBase.taskDao().getAll(userEmail)
    }

}