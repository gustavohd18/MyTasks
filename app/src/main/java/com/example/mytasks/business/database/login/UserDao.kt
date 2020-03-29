package com.example.mytasks.business.database.login

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE email like :emailUser")
    fun findUSer(emailUser: String): User

    @Query("SELECT * FROM user WHERE email like :emailUser and password =:password")
    fun findValidUSer(emailUser: String, password: String): User

    @Insert
    fun insertUser(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("UPDATE user SET password =:newPassword WHERE email =:email")
    fun updatePassword(email: String, newPassword: String)

}
