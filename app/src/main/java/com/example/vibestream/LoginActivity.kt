package com.example.vibestream

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        //stay without login
        val newButton: Button = findViewById(R.id.stay)

        newButton.setOnClickListener {
            // Navigate to Home
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //stay without login
        val log: ImageView = findViewById(R.id.log)

        log.setOnClickListener {
            // Navigate to reg
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        

        //login function
        val etEmail = findViewById<EditText>(R.id.email)
        val etPassword = findViewById<EditText>(R.id.pwd)
        val btnLogin = findViewById<Button>(R.id.logbtn)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email == "dilshan@gmail.com" && password == "1205") {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}