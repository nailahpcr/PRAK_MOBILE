package com.example.doraapps.Home.pertemuan13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ThirteenthTabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // Menentukan jumlah tab total (Capture, QR Code, Scan)
    override fun getItemCount(): Int = 3

    // Menentukan fragment mana yang muncul berdasarkan posisi tab (0, 1, atau 2)
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabQrcodeFragment()
            2 -> TabScanFragment()
            else -> TabCaptureFragment()
        }
    }
}