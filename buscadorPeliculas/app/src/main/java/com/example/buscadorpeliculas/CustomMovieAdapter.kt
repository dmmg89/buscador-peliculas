package com.example.buscadorpeliculas

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomMovieAdapter: RecyclerView.Adapter<CustomMovieAdapter.ViewHolder>() {

    var moviesData = ""

    val titles = mutableListOf<String>()


    val details = arrayOf("Detalles 1",
                            "Detalles 2",
                            "Detalles 3",
                            "Detalles 4"
                                        )


    val images = arrayOf(R.drawable.baseline_check_circle_24,
                        R.drawable.baseline_check_circle_24,
                        R.drawable.baseline_check_circle_24,
                        R.drawable.baseline_check_circle_24
                                                            )

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        searchByMovie()
        Log.d("coroutine work", this.givenString(moviesData))
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_movies_layout,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = titles.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
       viewHolder.itemTitle.text = titles[position]
        viewHolder.itemDetails.text = details[position]
        viewHolder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetails: TextView

        init {
            itemImage = itemView.findViewById(R.id.movie_image)
            itemTitle = itemView.findViewById(R.id.movie_title)
            itemDetails = itemView.findViewById(R.id.movie_details)
        }

    }



    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://345105ab-ba2f-4b12-9b2d-be012361b9eb.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByMovie():String{

        CoroutineScope(Dispatchers.IO).launch {
            val call:Response<MoviesDataClass> = getRetrofit().create(APImovies::class.java)
                .getMoviesAll("/cines/1/peliculas")

            val movies:MoviesDataClass? = call.body()



            moviesData = if (call.isSuccessful){
                movies?.information.toString()
            }else{
                "sin respuesta"

            }


        }
        return moviesData
    }

    fun givenString(cadena:String):String{
        return moviesData
    }

}