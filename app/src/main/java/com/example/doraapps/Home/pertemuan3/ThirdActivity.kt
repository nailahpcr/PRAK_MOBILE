package com.example.doraapps.Home.pertemuan3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityThirdBinding
import android.content.Intent

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hubungkan variabel dengan ID yang ada di XML
        //val inputNoTujuan = findViewById<EditText>(R.id.inputNoTujuan)
        //val btnKirim = findViewById<Button>(R.id.btnKirim)

        // Logika ketika tombol ditekan
        binding.btnKirim.setOnClickListener {
            val nomor = binding.inputNoTujuan.text.toString()

            if (nomor.isNotEmpty()) {
                val pesan = "Pesan berhasil dikirim ke $nomor"
                Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Silahkan isi nomor tujuan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}