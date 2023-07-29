package com.example.buscadorpeliculas.cinemaOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.cinemaOption.FranchiseEnum.*


class SelectedTheaterTopFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_selected_theater_top, container, false)

        val activity = activity as SelectedTheater

        var logo = view.findViewById<ImageView>(R.id.selectedTheaterPicture)
        var title = view.findViewById<TextView>(R.id.selectedTheaterTitle)
        var sloganText = view.findViewById<TextView>(R.id.selectedTheaterSlogan)
        val slogan:String?

        when(activity.franquicia){
            CINEDOT.franchise -> {
                logo.setImageResource(R.drawable.logo_cinedot)
                title.text = CINEDOT.franchise
                sloganText.text= CINEDOT.slogan
            }

            CINEPOLIS.franchise -> {
                logo.setImageResource(R.drawable.logo_cinepolis)
                title.text = CINEPOLIS.franchise
                sloganText.text= CINEPOLIS.slogan
            }

            CINEMEX.franchise -> {
                logo.setImageResource(R.drawable.logo_cinemex)
                title.text = CINEMEX.franchise
                sloganText.text = CINEMEX.slogan
            }
        }





        return view
    }


}