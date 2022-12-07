package com.example.android.f1pilot.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.f1pilot.data.model.F1Pilot

@Dao
interface FavF1PilotDao {
    @Insert
    suspend fun setFav(fav: F1Pilot)

    @Query("Select * from F1PilotTable WHERE id  = :id")
    suspend fun getFavCharacterById(id: Int): F1Pilot

    @Query("Select * from F1PilotTable")
    suspend fun getFavCharacter(): List<F1Pilot>

    @Query("Update F1PilotTable set isFav=:isFav where id = :id")
    suspend fun update(id: Int, isFav: Boolean)
/*
    @Query("Update favCharacter set isFav=:isFav  WHERE id = :id")
    fun updateCharacter(id:String, isFav: Boolean)
*/
}