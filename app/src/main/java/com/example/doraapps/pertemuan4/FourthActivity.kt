package com.example.doraapps.pertemuan4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("onCreate", "FourthActivity dibuat pertama kali")

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Klik tombol untuk kembali ke MainActivity
        binding.btnBack.setOnClickListener {
            finish()
        }

        // --- Tambahan Alert Dialog ---
        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }

        // --- Tambahan Snackbar ---
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        // Log Intent Data
        val name = intent.getStringExtra("nama")
        val from = intent.getStringExtra("asal")
        val age = intent.getIntExtra("usia", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")
    }

    // --- Lifecycle Methods ---
    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "FourthActivity siap berinteraksi")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "FourthActivity dijeda")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "FourthActivity tidak lagi terlihat")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}