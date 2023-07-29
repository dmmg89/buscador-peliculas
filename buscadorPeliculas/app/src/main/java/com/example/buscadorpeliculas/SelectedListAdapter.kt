package com.example.buscadorpeliculas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

val selectedFilmItem = listOf<SelectedListItem>(
    SelectedListItem("Titulo 1", arrayOf("1","2")),
    SelectedListItem("Titulo 1", arrayOf("1","2")),
    SelectedListItem("Titulo 1", arrayOf("1","2"))
)


class SelectedListAdapter(context:Context, items: List<SelectedListItem>):
    ArrayAdapter<SelectedListItem>(context,0,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var selectedFilmView = convertView

        if (selectedFilmView == null) {
            selectedFilmView =
                LayoutInflater.from(context).inflate(R.layout.list_selected_film, parent, false)
        }

        val currentItem = getItem(position)
        val selectedFilmTitle = selectedFilmView?.findViewById<TextView>(R.id.titleSelectedFilm)
        val selectedFilmSubTitle =
            selectedFilmView?.findViewById<TextView>(R.id.subtitleSelectedFilm)

        selectedFilmTitle?.text = currentItem?.title
        selectedFilmSubTitle?.text = currentItem?.subtitle.toString()

        return selectedFilmView!!
    }
}

public fun getSelectedFilmData() : List<SelectedListItem> {
    return selectedFilmItem
}
