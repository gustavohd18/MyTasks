package com.example.mytasks.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytasks.R
import com.example.mytasks.controllers.task.TaskController
import com.example.mytasks.views.login.LoginActivity
import com.example.mytasks.views.task.CreateTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var taskController : TaskController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskController = TaskController(this)

        val emailUser = intent.getStringExtra("EMAIL_USER")

        val shared = this.getSharedPreferences("mytasks", Context.MODE_PRIVATE)
        val email = shared.getString("EMAIL_USER", "")

        Toast.makeText(this,"Bem vindo $email", Toast.LENGTH_SHORT).show()


        imageBack.setOnClickListener {
            shared.edit().putString("EMAIL_USER", null).apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        imageView.setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            intent.putExtra("EMAIL_USER", email)
            startActivity(intent)
        }

    }

}
