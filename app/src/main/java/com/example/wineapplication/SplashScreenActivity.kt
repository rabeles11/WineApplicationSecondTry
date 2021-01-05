package com.example.wineapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.alpha
import android.os.Handler;

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()
        handler.postDelayed({
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }, 1000)


    }
}