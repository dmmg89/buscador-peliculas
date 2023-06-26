package com.example.buscadorpeliculas

import com.google.gson.annotations.SerializedName

data class MoviesDataClass(@SerializedName("status") var status:String,
                           @SerializedName("item") var information:List<String>)
