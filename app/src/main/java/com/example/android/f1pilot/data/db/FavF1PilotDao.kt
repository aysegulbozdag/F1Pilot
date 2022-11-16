package com.example.android.f1pilot.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavF1PilotDao {
    @Insert
    fun setFav(fav:FavF1PilotEntity)

 /*   @Query("Select * from favF1PilotEntity WHERE id  = :id")
    fun getFavCharacter(id: String) : LiveData<FavF1PilotEntity>

    @Query("Update favCharacter set isFav=:isFav  WHERE id = :id")
    fun updateCharacter(id:String, isFav: Boolean)
*/
}