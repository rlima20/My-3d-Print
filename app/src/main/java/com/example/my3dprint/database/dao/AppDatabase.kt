package com.example.my3dprint.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my3dprint.model.Part
import com.example.my3dprint.model.Print


@Database(
    version = 1,
    entities = [Print::class, Part::class],
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun printDao(): PrintDAO
    abstract fun saveDao(): PrintDAO
}
