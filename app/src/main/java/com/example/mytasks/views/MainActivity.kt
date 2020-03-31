package com.example.mytasks.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytasks.R
import com.example.mytasks.controllers.task.TaskController
import com.example.mytasks.views.login.LoginActivity
import com.example.mytasks.views.task.CreateTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var taskController: TaskController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerType: Spinner = findViewById(R.id.spinner_type)
        ArrayAdapter.createFromResource(
            this,
            R.array.type_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerType.adapter = adapter
        }

        val spinnerPriority: Spinner = findViewById(R.id.spinner_priority)
        ArrayAdapter.createFromResource(
            this,
            R.array.priority_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPriority.adapter = adapter
        }

        val spinnerIsCompleted: Spinner = findViewById(R.id.spinner_completed)
        ArrayAdapter.createFromResource(
            this,
            R.array.completec_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerIsCompleted.adapter = adapter
        }

        taskController = TaskController(this)

        val emailUser = intent.getStringExtra("EMAIL_USER")

        val shared = this.getSharedPreferences("mytasks", Context.MODE_PRIVATE)
        val email = shared.getString("EMAIL_USER", "")

        Toast.makeText(this, "Bem vindo $email", Toast.LENGTH_SHORT).show()


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
