package com.example.my3dprint.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.my3dprint.model.PartFromPrint
import com.example.my3dprint.model.Print

@Dao
interface PrintDAO {

    @Transaction
    @Query("SELECT * FROM Part")
    fun getPrintsWithParts(): List<PartFromPrint>

    @Query("SELECT * FROM Print")
    fun getAllPrints(): LiveData<List<Print>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePrint(print: Print)

    @Insert
    fun salva(vararg print: Print)

    @Delete
    fun remove(print: Print)
}