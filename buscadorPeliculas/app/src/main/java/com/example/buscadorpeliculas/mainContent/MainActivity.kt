package com.example.buscadorpeliculas.mainContent

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.buscadorpeliculas.APImovies
import com.example.buscadorpeliculas.CinemaData
import com.example.buscadorpeliculas.CinemaDb
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding


    //api
    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService = retrofit.create(APImovies::class.java)

    companion object{
        const val PERMISION_ID = 33
    }






    @RequiresApi(34)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//inicia base de datos
        val db = Room.databaseBuilder(applicationContext,CinemaDb::class.java,"cineDb")
            .allowMainThreadQueries()
            .build()
        val userDao = db.cinemaDao()


//se establece el fragmento que contiene al título
        initializeTopFragment(TopContent())
        val topFragment = supportFragmentManager.findFragmentById(R.id.topContainer)
        val topTextView = findViewById<TextView>(R.id.topTitle)

        suspend fun apiCharge(){
            try {
                Log.i(TAG, "RESPUESTA DE API")
                for (index in 1..10) {

                    val respuesta = apiService.getMoviesAll(index)
                    val cadena = respuesta.franchise
                    val nombre = respuesta.name
                    val latitud = respuesta.latitude
                    val longitud = respuesta.longitude

                    //Carga en base de datos

                    val cinemaEntry = CinemaData(id= index, franchise = cadena, name = nombre, latitude = latitud,longitude = longitud)
                    userDao.insertCinema(cinemaEntry)
                    Log.i(TAG, "Cinema id $index Cargado en base de datos")

                    Log.d(TAG, "La cadena es $cadena, $nombre")
                    Log.d(TAG, "La posición es $latitud ,  $longitud")
                }

            }catch (e: Exception){
                Log.d(TAG, "CONSULA API FALLIDA")
                Log.d(TAG,e.toString())
            }
        }

        suspend fun apiConsult() {
            val consulta = userDao.getCinema()
            Log.i(TAG, "consulta de prueba")
            Log.i(TAG, consulta.first().toString())
        }

        GlobalScope.launch {
            try {
                apiCharge()
                val numeroEntradas = userDao.getCount()
                if (numeroEntradas != 0){
                Log.d(TAG, "numero entradas "+ numeroEntradas)}


                else{
                    Log.w(TAG,"Base de datos vacía")
                }
                val consulta = userDao.getCinema()
                Log.d(TAG, consulta.first().toString())

            }catch (e:Exception){
                Log.d(TAG,e.message.toString())
            }

        }


        val nombre = this.intent.extras?.getString("email")
        Log.d(TAG, "usuario almacenado en el intent  " + nombre.toString())
        replaceFragmentContent(MoviesFragment())
        showMessage(nombre?: "Usuario no registrado ")



        binding.bottomNavigationView.menu.findItem(R.id.moviesBottom).setChecked(true)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.moviesBottom -> {
                    replaceFragmentContent(MoviesFragment())
                   //getLocation()



                }
                R.id.theaterBottom -> {
                    replaceFragmentContent(TheaterFragment())

                }
                R.id.accountBottom -> {
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




    fun showMessage(message:String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }



}






