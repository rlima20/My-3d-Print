package com.example.my3dprint.repository

import com.example.my3dprint.database.dao.PrintDAO
import com.example.my3dprint.model.PartFromPrint
import com.example.my3dprint.model.Print

class PrintRepository(private val dao: PrintDAO) {

    fun getAllPrintsWithParts(): List<PartFromPrint> {
        return dao.getPrintsWithParts()
    }

    fun getAllPrints(): List<Print> {
        return dao.getAllPrints()
    }

    fun save(print: Print){
        dao.savePrint(print)
    }

    fun remove(print: Print){
        dao.remove(print)
    }
}