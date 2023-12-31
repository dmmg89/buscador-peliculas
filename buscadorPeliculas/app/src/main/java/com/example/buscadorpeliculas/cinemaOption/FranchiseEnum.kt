package com.example.buscadorpeliculas.cinemaOption

import android.content.res.Resources
import com.example.buscadorpeliculas.R

enum class FranchiseEnum(val franchise:String, val slogan:String, logo: Int) {

    CINEDOT("Cinedot", "El punto de encuentro que crea conexiones", R.drawable.logo_cinedot),
    CINEPOLIS("Cinepolis", "La capital del cine",R.drawable.logo_cinepolis),
    CINEMEX("Cinemex", "La magia del cine", R.drawable.logo_cinemex)


}