package com.example.android.f1pilot.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavF1PilotEntity(
    @PrimaryKey
    val id : Int,
    @ColumnInfo(name = "isFav")
    var isFav: Boolean = false
)