package com.example.doraapps.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // Dummy Login Logic
            if (email == "admin@mail.com" && password == "admin123") {
                sessionManager.saveLoginStatus(true)
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                
                startActivity(Intent(this, MainActivityP6::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}