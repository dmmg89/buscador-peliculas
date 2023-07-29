package com.example.buscadorpeliculas.mainContent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.buscadorpeliculas.R


class TopContent : Fragment() {

    private lateinit var topTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_content, container, false)
        topTextView = view?.findViewById(R.id.topTitle)!!

        val dateTop = com.example.buscadorpeliculas.start.SharedData.formattedDate

        updateTextView("BIENVENID@\n" +dateTop.toString())
            return view

    }



    public fun updateTextView(updateText:String){
        topTextView.text = updateText
    }

}
