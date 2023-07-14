package com.example.buscadorpeliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class TheaterFragment : Fragment() {

    private lateinit var toptitle: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView2 = inflater.inflate(R.layout.fragment_theater,container,false)
        return rootView2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerViewFranchise = view.findViewById<RecyclerView>(R.id.franchiseRecycler)
        val adapter = CustomCinemaAdapter(this)
        recyclerViewFranchise.layoutManager = LinearLayoutManager(context)
        recyclerViewFranchise.adapter = adapter

        CoroutineScope(Dispatchers.IO).launch {
           /* try {
                //val respuesta =
            }*/
        }

    }

}