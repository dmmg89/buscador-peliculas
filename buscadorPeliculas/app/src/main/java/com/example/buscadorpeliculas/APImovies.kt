package com.example.buscadorpeliculas

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface APImovies {

    @GET("/dmmg89/dbMovies/posts/{id}")
    suspend fun getMoviesAll(@Path("id") postId:Int):Post


}