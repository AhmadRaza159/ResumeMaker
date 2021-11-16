package com.example.resumemaker.objectives

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.profile.BasicInfo

@Dao
interface ObjectivesDao  {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addObjective(objective: Objective)

    @Query("SELECT * FROM objectives_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Objective>>

    @Delete
    fun delete(model:Objective)
}