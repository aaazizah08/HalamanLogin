package com.example.tugashalamanlogin

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val emailString = emailEditText.text.toString().trim()
            val passwordString = passwordEditText.text.toString().trim()

            if (emailString.isEmpty()) {
                emailEditText.error = "Email tidak boleh kosong!"
                return@setOnClickListener
            }
            if (passwordString.isEmpty()) {
                passwordEditText.error = "Password tidak boleh kosong!"
                return@setOnClickListener
            }

            if (emailString == "email@string.com" && passwordString == "password") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", emailString)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
