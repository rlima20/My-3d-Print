package com.example.my3dprint.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.my3dprint.model.PartFromPrint

@Dao
interface PrintDAO {

    @Transaction
    @Query("SELECT * FROM Part")
    fun getPrintsWithParts(): List<PartFromPrint>
}