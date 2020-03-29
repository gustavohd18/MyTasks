package com.example.mytasks.views.login

import android.content.ClipData.newIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytasks.R
import com.example.mytasks.controllers.login.LoginController
import kotlinx.android.synthetic.main.activity_forget.*

class ForgetActivity : AppCompatActivity() {

    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)


        loginController = LoginController(this)

        imageBack.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
        buttonValid.setOnClickListener {
            val email = editEmail.text.toString()

            if (loginController.isValidUSer(email)) {

                val intent = Intent(this, NewPasswordActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario nao encontrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}
