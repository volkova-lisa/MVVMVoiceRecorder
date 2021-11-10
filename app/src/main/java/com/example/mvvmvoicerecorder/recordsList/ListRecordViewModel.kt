package com.example.mvvmvoicerecorder.recordsList

import androidx.lifecycle.ViewModel
import com.example.mvvmvoicerecorder.database.RecordDao

class ListRecordViewModel (
    dataSource: RecordDao
) : ViewModel() {

    val database = dataSource
    val records = database.getAllRecords()
}