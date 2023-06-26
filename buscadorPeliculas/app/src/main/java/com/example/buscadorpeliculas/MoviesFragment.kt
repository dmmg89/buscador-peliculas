package com.example.buscadorpeliculas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("created view", "Se creo la vista de peliculas")
        val rootView = inflater.inflate(R.layout.fragment_movies, container, false)


        //val listView: ListView = rootView.findViewById(R.id.moviesList)


        //Peliculas a obtenerse desde servidor
//        val moviesData = arrayOf( "Pelicula1", "Pelicula2", "Pelicula3")
//
//        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, moviesData)
//        listView.adapter = adapter
//



        return rootView
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewMovies= view.findViewById<RecyclerView>(R.id.moviesRecycler)
        val adapter = CustomMovieAdapter()

        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
        recyclerViewMovies.adapter = adapter
        Log.d("Movie Fragment updated", " actualizado el fragmento, ya con el adaptador")
    }




}

