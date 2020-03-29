package com.example.mytasks.views.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytasks.R
import com.example.mytasks.controllers.login.LoginController
import kotlinx.android.synthetic.main.activity_new_password.*

class NewPasswordActivity : AppCompatActivity() {

    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        loginController = LoginController(this)

        buttonvalidPass.setOnClickListener {
            val email = intent.getStringExtra("email")

            val pass = editConfirmed.text.toString()
            val passVerify = editText.text.toString()

            if (pass == passVerify) {
                if (loginController.updatePassword(email, pass)) {
                    Toast.makeText(this, "Senha alterada com sucesso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            } else {
                Toast.makeText(this, "Senha nao bate", Toast.LENGTH_LONG).show()
            }

        }
    }
}
