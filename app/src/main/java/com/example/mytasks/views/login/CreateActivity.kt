package com.example.mytasks.views.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytasks.R
import com.example.mytasks.controllers.login.LoginController
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        loginController = LoginController(this)

        val shared = this.getSharedPreferences("mytasks", Context.MODE_PRIVATE)

        buttonCreate.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editTextPassword.text.toString()
            val name = editTextName.text.toString()

            val result = loginController.insert(email,password,name)

            if(result) {
                Toast.makeText(this, "Conta criada com sucesso",Toast.LENGTH_LONG).show()
                shared.edit().putString("EMAIL_USER",email).apply()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "Não foi possivel criar a conta",Toast.LENGTH_LONG).show()
            }
        }

        imageBack.setOnClickListener {  startActivity(Intent(this, LoginActivity::class.java)) }
    }

}
