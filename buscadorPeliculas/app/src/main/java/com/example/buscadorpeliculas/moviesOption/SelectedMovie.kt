package com.example.buscadorpeliculas.moviesOption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.buscadorpeliculas.R

class selectedMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_movie)

        replaceFragmentContent(selectedMovieFragment())
    }




    private fun replaceFragmentContent(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.movieSelectedRecycler, fragment)
        fragmentTransaction.commit()
    }


    private fun initializeTopFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.movieSelectedTop, fragment)
        fragmentTransaction.commit()

    }

}