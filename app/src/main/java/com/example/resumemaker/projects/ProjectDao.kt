package com.example.resumemaker.projects

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.skills.Skill

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProjects(project: Project)
    @Query("SELECT * FROM project_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Project>>

    @Delete
    fun delete(model:Project)
}