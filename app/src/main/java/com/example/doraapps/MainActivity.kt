package com.example.doraapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityMainBinding
import com.example.doraapps.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Klik tombol untuk ke FourthActivity
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
        val intent = Intent(this, FourthActivity::class.java)

        /*tambahkan bagian berikut*/
        intent.putExtra("nama", "Politeknik Caltex Riau")
        intent.putExtra("asal", "Rumbai")
        intent.putExtra("usia", 25)

    }
}