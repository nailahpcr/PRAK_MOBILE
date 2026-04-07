package com.example.nailah_cookie
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3.databinding.ActivityMain2Binding
import com.example.pertemuan3.R
import com.example.pertemuan3.WelcomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi ViewBinding untuk activity_main
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            val username = binding.inputNoTujuan.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.inputNoTujuan.error = getString(R.string.error_username)
                binding.inputNoTujuan.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.inputPassword.error = getString(R.string.error_password)
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Login berhasil: $username", Toast.LENGTH_SHORT).show()

            // Berpindah ke WelcomeActivity
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }
    }
}