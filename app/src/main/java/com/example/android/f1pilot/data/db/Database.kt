package com.example.android.f1pilot.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [FavF1PilotEntity::class], version = 1)
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
                            "favCharacterDB"
                        ).build()
                    }
                }
            }
            return db
        }
    }
}