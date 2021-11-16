package com.example.resumemaker.skills

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.experience.Experience

@Dao
interface SkillDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSkills(skill: Skill)
    @Query("SELECT * FROM skills_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Skill>>

    @Delete
    fun delete(moddel:Skill)
}