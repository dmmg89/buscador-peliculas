package com.example.buscadorpeliculas

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.health.connect.datatypes.ExerciseRoute.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.buscadorpeliculas.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var fusedLocationClient : FusedLocationProviderClient

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

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


//se establece el fragmento que contiene al título
        initializeTopFragment(TopContent())
        val topFragment = supportFragmentManager.findFragmentById(R.id.topContainer)
        val topTextView = findViewById<TextView>(R.id.topTitle)

        lifecycleScope.launch {
            try {
                Log.i(TAG, "RESPUESTA DE API")
                for (index in 1..4) {

                    val respuesta = apiService.getMoviesAll(index)
                    val cadena = respuesta.franchise
                    val nombre = respuesta.name
                    val latitud = respuesta.latitude
                    val longitud = respuesta.longitude

                    Log.d(TAG, "La cadena es $cadena, $nombre")
                    Log.d(TAG, "La posición es $latitud ,  $longitud")
                }

            }catch (e: Exception){
                Log.d(TAG, "CONSULA API FALLIDA")
                Log.d(TAG,e.toString())
            }
        }



        val nombre = this.intent.extras?.getString("email")
        Log.d(TAG, nombre.toString())
        replaceFragmentContent(AccountFragment())


        binding.bottomNavigationView.menu.findItem(R.id.accountBottom).setChecked(true)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.moviesBottom-> {
                    replaceFragmentContent(MoviesFragment())
                    getLocation()
                }
                R.id.theaterBottom-> {
                    replaceFragmentContent(TheaterFragment())
                    getLocation()
                }
                R.id.accountBottom-> {
                    replaceFragmentContent(AccountFragment())
                    getLocation()
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

    @RequiresApi(34)
    private fun getLocation(){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            fusedLocationClient.lastLocation.addOnSuccessListener {
                Log.d("gps Latitud", it.latitude.toString())
                Log.d("gps Longitud", it.longitude.toString())


            }

            }else{
                Log.w(TAG,"LOCALIZACION GPS NO ENCONTRADA")
            }
    }

}

    /*fun mostrarToast(mensaje:String){
        Toast.makeText(Context,mensaje, Toast.LENGTH_LONG).show()
    }*/





