package com.example.android.f1pilot.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.f1pilot.data.model.F1Pilot

@androidx.room.Database(entities = [F1Pilot::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun favDao(): FavF1PilotDao

    companion object {
        private var db: Database? = null

        fun getDatabase(context: Context): Database? {
            if (db == null) {
                synchronized(Database::class.java) {
                    if (db == null) {
                        db = Room.databaseBuilder(
                            context,
                            Database::class.java,
                            "F1PilotDB"
                        ).build()
                    }
                }
            }
            return db
        }
    }
}