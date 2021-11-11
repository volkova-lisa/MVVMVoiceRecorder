package com.example.mvvmvoicerecorder.listRecord

import androidx.lifecycle.ViewModel
import com.example.mvvmvoicerecorder.database.RecordDatabaseDao

class ListRecordViewModel (
    dataSource: RecordDatabaseDao
) : ViewModel() {

    val database = dataSource
    val records = database.getAllRecords()
}