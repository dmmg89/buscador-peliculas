package com.example.buscadorpeliculas.cinemaOption

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.buscadorpeliculas.R

class SelectedTheater : AppCompatActivity() {

    lateinit var franquicia:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_theater)



        franquicia = intent.getStringExtra("Franchise").toString()
        Log.d(TAG, "Franquicia seleccionada " + franquicia)





        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.theaterSelectedTop, SelectedTheaterTopFragment())
                .commit()
        }


            val fragmentBody = SelectedTheaterFragment()
            supportFragmentManager.beginTransaction().add(R.id.theaterSelectedRecycler, fragmentBody).commit()




    }




}



