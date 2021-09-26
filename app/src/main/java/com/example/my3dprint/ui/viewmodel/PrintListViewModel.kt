package com.example.my3dprint.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.my3dprint.model.Print
import com.example.my3dprint.repository.PrintRepository

class PrintListViewModel(
    private val repository: PrintRepository
): ViewModel() {

    fun getAllPrints(): LiveData<List<Print>> = repository.getAllPrints()
}