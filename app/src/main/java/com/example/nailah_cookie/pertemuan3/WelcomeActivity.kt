package com.example.pertemuan3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Opsional: Jika ingin menampilkan username yang dikirim dari Login
        val username = intent.getStringExtra("USERNAME")
        if (username != null) {
            binding.tvDesc.text = "Halo $username,\nSelamat datang kembali!"
        }
    }
}