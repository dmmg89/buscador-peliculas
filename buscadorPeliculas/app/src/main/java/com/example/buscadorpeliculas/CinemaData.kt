package com.example.buscadorpeliculas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CinemaData(
    @PrimaryKey(autoGenerate = true) val id: Int= 1,
    @ColumnInfo val franchise:String,
    @ColumnInfo val name: String,
    @ColumnInfo val latitude:String?,
    @ColumnInfo val longitude:String?,
)
