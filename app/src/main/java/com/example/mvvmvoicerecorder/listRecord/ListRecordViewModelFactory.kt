package com.example.mvvmvoicerecorder.listRecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmvoicerecorder.database.RecordDatabaseDao
import java.lang.IllegalArgumentException

class ListRecordViewModelFactory (
    private val databaseDao: RecordDatabaseDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListRecordViewModel::class.java)) {
            return ListRecordViewModel(databaseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}