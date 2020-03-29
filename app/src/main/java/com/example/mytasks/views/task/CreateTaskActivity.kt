package com.example.mytasks.views.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.mytasks.R
import com.example.mytasks.controllers.task.TaskController
import com.example.mytasks.views.MainActivity
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.coroutines.yield
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog as DatePickerDialog

class CreateTaskActivity : AppCompatActivity() {
    private lateinit var taskController : TaskController

    private lateinit var dataDialog: DatePickerDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        taskController = TaskController(this)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        lateinit var date: String

        buttonDate.setOnClickListener {

            dataDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                    date = "${dayOfMonth}/${monthOfYear+1}/${year}"
                    Toast.makeText(this,date, Toast.LENGTH_SHORT).show()

                },
                year,
                month,
                day
            )

            dataDialog.show()
        }

        buttonCreate.setOnClickListener {
            val name = editNameTask.text.toString()
            val description = editTextDescription.text.toString()
            val dateCapture = date
            val selectIDPriority = radioGroupPriority.checkedRadioButtonId
            val selectIDType = radioGroupType.checkedRadioButtonId
            val priority = findViewById<RadioButton>(selectIDPriority).text.toString()
            val type = findViewById<RadioButton>(selectIDType).text.toString()
            val emailUser = intent.getStringExtra("EMAIL_USER")

            if(taskController.create(name, description, emailUser, type, dateCapture, priority)) {
                Toast.makeText(this, "Item adicionado", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Ocorreu um erro ao adicionar a tarefa", Toast.LENGTH_LONG).show()
            }
        }

        imageBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
