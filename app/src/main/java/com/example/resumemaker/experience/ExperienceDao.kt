package com.example.resumemaker.experience

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.objectives.Objective

@Dao
interface ExperienceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addExperience(experience: Experience)

    @Query("SELECT * FROM experience_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Experience>>

    @Delete
    fun delete(model:Experience)

    @Update
    fun updateData(model: Experience)
}