package com.example.buscadorpeliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class MoviesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movies, container, false)
        val rootView = inflater.inflate(R.layout.fragment_movies, container, false)



        val listView: ListView = rootView.findViewById(R.id.moviesList)


        //Peliculas a obtenerse desde servidor
        val moviesData = arrayOf( "Pelicula1", "Pelicula2", "Pelicula3")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, moviesData)
        listView.adapter = adapter

        return rootView
    }


}