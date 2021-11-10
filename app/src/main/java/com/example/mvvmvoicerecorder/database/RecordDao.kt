package com.example.mvvmvoicerecorder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecordDao {
    @Insert
    fun insert(record: RecordingItem)
    @Update
    fun update(record: RecordingItem)

    @Query("SELECT * from table_of_records WHERE id = :key")
    fun getRecord(key: Long?): RecordingItem?

    @Query("DELETE FROM table_of_records WHERE id = :key")
    fun removeRecord(key: Long?)

    @Query("SELECT * FROM table_of_records ORDER BY id DESC")
    fun getAllRecords(): LiveData<MutableList<RecordingItem>>

    @Query("DELETE FROM table_of_records")
    fun clearAll()
    @Query("SELECT COUNT(*) FROM table_of_records")
    fun getCount(): LiveData<Int>
}