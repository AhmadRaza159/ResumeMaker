package com.example.resumemaker.projects

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.skills.Skill

class ProjectRepository(private val projectDao: ProjectDao,private val id: String) {
    val readAllData: LiveData<List<Project>> = projectDao.readAllData(id)
    fun deleteData(obj: Project){
        projectDao.delete(obj)
    }
    suspend fun addProject(project: Project){
        projectDao.addProjects(project)
    }

    fun updateData(obj: Project){
        projectDao.updateData(obj)
    }
    fun readAllDat(id:String):LiveData<List<Project>>{
        return projectDao.readAllData(id)
    }

}