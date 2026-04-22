package com.example.doraapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityMainBinding
import com.example.doraapps.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        // 1. Klik tombol untuk ke FourthActivity dengan membawa data
//        binding.btnToFourth.setOnClickListener {
//            val intent = Intent(this, FourthActivity::class.java)
//
//            // Memasukkan data ke dalam intent
//            intent.putExtra("nama", "Politeknik Caltex Riau")
//            intent.putExtra("asal", "Rumbai")
//            intent.putExtra("usia", 25)
//
//            // Menjalankan intent
//            startActivity(intent)
//        }

        // 2. Klik tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    // Kembali ke AuthActivity
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intentAuth = Intent(this, AuthActivity::class.java)
                    startActivity(intentAuth)
                    finish() // Menutup MainActivity
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}