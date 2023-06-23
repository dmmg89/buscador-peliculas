package com.example.buscadorpeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.buscadorpeliculas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//se establece el fragmento que contiene al título
        initializeTopFragment(TopContent())
        val topFragment = supportFragmentManager.findFragmentById(R.id.topContainer)
        val topTextView = findViewById<TextView>(R.id.topTitle)


        replaceFragmentContent(AccountFragment())
        binding.bottomNavigationView.menu.findItem(R.id.accountBottom).setChecked(true)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.moviesBottom-> {
                    replaceFragmentContent(MoviesFragment())



                }
                R.id.theaterBottom-> {
                    replaceFragmentContent(TheaterFragment())

                }
                R.id.accountBottom-> {
                    replaceFragmentContent(AccountFragment())

                }

                else-> {}

            }
            true
        }


    }



    private fun replaceFragmentContent(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun initializeTopFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.topContainer, fragment)
        fragmentTransaction.commit()

    }

}