package com.example.buscadorpeliculas

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APImovies {

    @GET
    suspend fun getMoviesAll(@Url url:String):Response<MoviesDataClass>


}