package com.example.doraapps.Home.pertemuan6

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

        // Cek status login
        if (sessionManager.isLoggedIn()) {
            startActivity(Intent(this, MainActivityP6::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.tilUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilUsername.error = null
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            val savedUsername = sessionManager.getUsername()
            val savedPassword = sessionManager.getPassword()

            // Logic Login Sesuai Ketentuan:
            // 1. Jika username == password
            // 2. Jika username == savedUsername && password == savedPassword
            val isSameUserPass = username == password
            val isRegisteredUser = !savedUsername.isNullOrEmpty() && username == savedUsername && password == savedPassword

            if (isSameUserPass || isRegisteredUser) {
                sessionManager.saveLoginStatus(true)
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                
                startActivity(Intent(this, MainActivityP6::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigasi ke halaman registrasi
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}