package com.example.buscadorpeliculas.moviesOption

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.SelectedListAdapter
import com.example.buscadorpeliculas.SelectedListItem


class selectedMovieFragment : Fragment() {




    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val rootView = inflater.inflate(R.layout.fragment_selected_movie, container, false)
        val lista = rootView.findViewById<ListView>(R.id.listFilmByMovie)

        val datos = arrayOf("Elemento 1",
                                "elemento 2",
                                "elemento 3")

         val adaptador = ArrayAdapter(requireContext(), R.id.listFilmByMovie,datos)

        lista.adapter = adaptador


        return rootView
    }


}