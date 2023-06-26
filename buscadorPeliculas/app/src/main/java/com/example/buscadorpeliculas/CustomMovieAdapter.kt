package com.example.buscadorpeliculas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomMovieAdapter: RecyclerView.Adapter<CustomMovieAdapter.ViewHolder>() {

    val titles = arrayOf("Pelicula 1",
                        "Pelicula 2",
                        "Pelicula 3",
                        "Pelicula 4"
                                      )

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
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_movies_layout,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

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

}