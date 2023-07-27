package com.example.buscadorpeliculas.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buscadorpeliculas.R
import com.example.buscadorpeliculas.moviesOption.selectedMovie
import com.example.buscadorpeliculas.start.ColorBank


class CustomMovieAdapter: RecyclerView.Adapter<CustomMovieAdapter.ViewHolder>() {

    //var moviesData = ""

    val titles = mutableListOf<String>("Spiderman: a través del spider-verso",
                                        "Transformers: el despertar de las bestias",
                                        "Post Mortem: fotos del más allá",
                                        "Elementos")


    val details = arrayOf("Clasificación: A \n Duración 136 min",
                            "Clasificación: B \n Duración: 126 min",
                            "Clasificación: B \n Duración: 115 min",
                             "Clasificación: A \n Duración 110 min"
                                        )


    val images = arrayOf(
        R.drawable.spidermancartel,
        R.drawable.transformerscartel,
        R.drawable.postmortemcartel,
        R.drawable.elementalcartel
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        searchByMovie()
//        Log.d("coroutine work", this.givenString(moviesData))
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_movies_layout,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = titles.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
       viewHolder.itemTitle.text = titles[position]
        viewHolder.itemDetails.text = details[position]
        viewHolder.itemImage.setImageResource(images[position])

        viewHolder.itemButton.setOnClickListener{

        val context = viewHolder.itemView.context
            val intent =Intent(context, selectedMovie::class.java)
            intent.putExtra("Pelicula", "Nombre")
            context.startActivity(intent)


        }


    }


    //clase interna, para declarar los elementos dentro de cada cardview
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetails: TextView
        var itemButton : Button

        init {
            itemImage = itemView.findViewById(R.id.movie_image)
            itemTitle = itemView.findViewById(R.id.movie_title)
            itemDetails = itemView.findViewById(R.id.movie_details)
            itemButton = itemView.findViewById(R.id.movie_button)
            itemButton.setBackgroundColor(itemView.context.resources.getColor(R.color.secundaryColor))
        }

    }





//    private fun searchByMovie():String{
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val call:Response<MoviesDataClass> = getRetrofit().create(APImovies::class.java)
//                .getMoviesAll("/cines/1/peliculas")
//
//            val movies:MoviesDataClass? = call.body()
//
//
//
//            moviesData = if (call.isSuccessful){
//                movies?.information.toString()
//            }else{
//                "sin respuesta"
//
//            }
//
//
//        }
//        return moviesData
//    }
//
//    fun givenString(cadena:String):String{
//        return moviesData
//    }

}
