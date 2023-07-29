package com.example.buscadorpeliculas.cinemaOption

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.room.Room
import com.example.buscadorpeliculas.CinemaDb
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.R.id.listSelectedFranchise


class SelectedTheaterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.fragment_selected_theater, container, false)

        val db = Room.databaseBuilder(view.context, CinemaDb::class.java,"cineDb")
            .allowMainThreadQueries()
            .build()
        val userDao = db.cinemaDao()


        val activity = activity as SelectedTheater
        activity.franquicia

        val consulta = userDao.getCinemaByFranchise(activity.franquicia)
        Log.d(TAG, "Consulta terminada de la base de datos")
        Log.d(TAG, consulta.first().toString())


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(view.context, CinemaDb::class.java,"cineDb")
            .allowMainThreadQueries()
            .build()
        val userDao = db.cinemaDao()


        val activity = activity as SelectedTheater
        activity.franquicia

        val consulta = userDao.getCinemaByFranchise(activity.franquicia)
        Log.d(TAG, "Consulta terminada de la base de datos")
        Log.i(TAG, "Longitud  ---  " + consulta.size)
        val recorte = mutableListOf<String>()

        val recorte2 = consulta


       /* try {
            for (index in 1..4){
                recorte.add(consulta[index].name)
                Log.d(TAG, recorte[index])
            }
        }catch (e:Exception){
            Log.w(TAG, e.message.toString())
        }*/



        Log.i(TAG, "Tamaño final " + recorte.size.toString())

        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, recorte2)

                val lista = view.findViewById<ListView>(listSelectedFranchise)

        lista.adapter = adaptador
    }


}