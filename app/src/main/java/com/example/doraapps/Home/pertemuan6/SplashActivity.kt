package com.example.doraapps.Home.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.doraapps.R
import com.example.doraapps.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animasi Splash Kustom
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        binding.ivLogo.startAnimation(animation)
        binding.tvAppName.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
            val sessionManager = SessionManager(this)
            if (sessionManager.isLoggedIn()) {
                startActivity(Intent(this, MainActivityP6::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 3000)
    }
}