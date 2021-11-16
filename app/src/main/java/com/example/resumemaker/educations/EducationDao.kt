package com.example.resumemaker.educations

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.skills.Skill

@Dao
interface EducationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEducation(education: Education)
    @Query("SELECT * FROM education_table  where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Education>>

    @Delete
    fun delete(model: Education)
}