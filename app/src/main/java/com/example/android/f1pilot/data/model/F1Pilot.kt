package com.example.android.f1pilot.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class F1Pilot(
     @PrimaryKey
      val id: Int,
      @ColumnInfo(name = "name")
      val name: String? = null,
      @ColumnInfo(name = "point")
      val point: Int? = null,
      @ColumnInfo(name = "isFav")
      var isFav: Boolean = false
)