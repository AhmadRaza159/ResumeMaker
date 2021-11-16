package com.example.resumemaker.profile

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BasicInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBasicInfo(basicInfo: BasicInfo)

    @Query("SELECT * FROM basic_info_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<BasicInfo>>

    @Delete
    fun delete(model:BasicInfo)
}