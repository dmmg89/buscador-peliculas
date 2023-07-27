package com.example.buscadorpeliculas.cinemaOption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buscadorpeliculas.R

class SelectedTheater : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_theater)


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.theaterSelectedTop, SelectedTheaterTopFragment())
                .commit()
        }
    }
}