package com.example.resumemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        supportActionBar?.hide()

        val handler = Handler()
        handler.postDelayed({
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}