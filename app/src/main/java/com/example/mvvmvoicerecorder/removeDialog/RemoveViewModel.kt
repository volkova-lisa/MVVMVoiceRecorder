package com.example.mvvmvoicerecorder.removeDialog

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mvvmvoicerecorder.R
import com.example.mvvmvoicerecorder.database.RecordDao
import com.example.mvvmvoicerecorder.database.RecordDatabase
import kotlinx.coroutines.*
import java.io.File
import java.lang.Exception

class RemoveViewModel(
    private var databaseDao: RecordDao,
    private val application: Application
) : ViewModel() {

    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun removeItem(itemId: Long) {
        databaseDao = RecordDatabase.getInstance(application).recordDao

        try {
            uiScope.launch {
                withContext(Dispatchers.IO) {
                    databaseDao.removeRecord(itemId)
                }
            }
        } catch (e: Exception) {
            Log.e("removeItem", "exception", e)
        }
    }

    fun removeFile(path: String) {
        val file = File(path)
        if (file.exists()) {
            file.delete()
            Toast.makeText(application, R.string.file_deleted_text, Toast.LENGTH_SHORT).show()
        }
    }
}










