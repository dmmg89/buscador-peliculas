package com.example.buscadorpeliculas

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CinemaData::class], version = 1)
abstract class CinemaDb:RoomDatabase() {

    abstract fun cinemaDao(): CinemaDao
}