package com.example.mytasks.views.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytasks.R
import com.example.mytasks.controllers.login.LoginController
import com.example.mytasks.views.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginController = LoginController(this)

        buttonCreate.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }

        button2.setOnClickListener { startActivity(Intent(this, ForgetActivity::class.java)) }

        val shared = this.getSharedPreferences("mytasks", Context.MODE_PRIVATE)

        if (shared.contains("EMAIL_USER")) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val email = editName.text.toString()
            val password = editText.text.toString()

            if (loginController.login(email, password)) {
                println(email)
                shared.edit().putString("EMAIL_USER", email).apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario nao encontrado", Toast.LENGTH_LONG).show()
            }

        }
    }
}
