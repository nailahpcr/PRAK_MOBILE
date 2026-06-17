package com.example.doraapps.Home.pertemuan13

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doraapps.R
import com.example.doraapps.databinding.ActivityThirteenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThirteenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirteenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding untuk Activity
        binding = ActivityThirteenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Mengatur Window Insets agar tidak terpotong status bar bawaan HP
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Setup Toolbar Utama & Pasang Judul
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 13"
            // Pastikan kamu memiliki icon ic_arrow_back berwarna putih di drawable kamu
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 4. Inisialisasi Adapter Khusus Pertemuan 13
        val tabsAdapter = ThirteenthTabsAdapter(this)

        // 5. Pasangkan Adapter ke komponen ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 6. Hubungkan TabLayout dengan ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab Capture"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_capture)
                }
                1 -> {
                    tab.text = "Tab QR Code"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_qrcode)
                }
                2 -> {
                    tab.text = "Tab Scan"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_scan)
                }
            }
        }.attach()
    }

    // Fungsi tombol navigasi kembali pada toolbar kiri atas
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}