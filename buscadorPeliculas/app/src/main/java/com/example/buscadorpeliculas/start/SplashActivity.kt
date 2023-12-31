package com.example.buscadorpeliculas.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.buscadorpeliculas.R

class SplashActivity : AppCompatActivity() {

    private val SPLASHTIMEOUT = 1_000L
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