package com.example.mytasks.controllers.login

import android.content.Context
import androidx.room.Room
import com.example.mytasks.business.database.AppDatabase
import com.example.mytasks.business.database.login.User
import java.util.regex.Pattern.compile

class LoginController (context: Context) {

    private val emailRegex = compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private val dataBase =  Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "tasks"
    ).allowMainThreadQueries().build() // verificar pois a docu diz pra nao usar allow problema concorrencia

    fun getAll() = dataBase.userDao().getAll()

    fun find(emailUser: String) = dataBase.userDao().findUSer(emailUser)

    fun insert(email: String, name: String, password: String): Boolean {

        if (email == "" || name == "" || password == "") {
            return false
        } else {

            if (!emailRegex.matcher(email).matches()) {
                return false
            }
            val user = User(email, name, password)

            val userVerify = find(email)

            userVerify?.let {
                return false
            }

            dataBase.userDao().insertUser(user)

            val userRequest = find(email)

            userRequest?.let {
                return true
            }

            return false
        }

    }

    fun login(email: String, password: String): Boolean {
        if (email == "" || password == "") {
            return false
        } else {

            if (!emailRegex.matcher(email).matches()) {
                return false
            }

            dataBase.userDao().findValidUSer(email, password)?.let {
                return true
            }

                return false
        }
    }

    fun isValidUSer(email: String): Boolean {

        if (email == "") {
            return false
        }
        val userVerify = find(email)

        userVerify?.let {
            return true
        }

        return false
    }

    fun updatePassword(email: String, password: String): Boolean {
        if (email == "" || password == "") {
            return false
        } else {
            if (!emailRegex.matcher(email).matches()) {
                return false
            }

            dataBase.userDao().updatePassword(email, password)
            return true
        }

    }

    fun delete(user: User) = dataBase.userDao().delete(user)
}