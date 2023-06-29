package com.example.buscadorpeliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TopContent : Fragment() {

    private lateinit var topTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_content, container, false)
        topTextView = view?.findViewById(R.id.topTitle)!!

        updateTextView("BIENVENID@")
            return view

    }



    public fun updateTextView(updateText:String){
        topTextView.text = updateText
    }

}
