package com.example.android.f1pilot.data.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class FavF1PilotEntity(
    @PrimaryKey
    val id : Int,
    @ColumnInfo(name = "isFav")
    val isFav: Boolean = false
)