package com.example.buscadorpeliculas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CinemaDao {

    @Insert
    fun insertCinema(cinemaData:CinemaData)

    @Update
    fun updateCinema(cinemaData: CinemaData)

    @Delete
    fun deleteCinema(cinemaData: CinemaData)

    @Query("SELECT COUNT(*) FROM CinemaData")
    fun getCount():Int

    @Query("SELECT * FROM CinemaData")
    fun getCinema(): List<CinemaData>

    @Query("SELECT * FROM CinemaData WHERE franchise = :franchise")
    fun getCinemaByFranchise(franchise: String): List<CinemaData>
}