package com.example.my3dprint.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Print(
    @PrimaryKey(autoGenerate = true)
    val printId: Long = 0,
    val printDescription: String = ""
)

@Entity
data class Part(
    @PrimaryKey(autoGenerate = true)
    val partId: Long = 0,
    val partDescription: String,
    val partPrintId: String
)

data class PartFromPrint(
    @Embedded val print: Print,
    @Relation(
        parentColumn = "printId",
        entityColumn = "partPrintId"
    )
    val parts: List<Part>
)



