package com.example.buscadorpeliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    private val SPLASHTIMEOUT = 3_000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                finish()},SPLASHTIMEOUT)


    }
}