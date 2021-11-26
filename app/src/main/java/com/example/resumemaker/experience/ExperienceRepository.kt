package com.example.resumemaker.experience

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.objectives.ObjectivesDao
import com.example.resumemaker.skills.Skill

class ExperienceRepository(private val experienceDao: ExperienceDao, private val id:String) {
    val readAllData: LiveData<List<Experience>> = experienceDao.readAllData(id)

    suspend fun addExperience(experience: Experience){
        experienceDao.addExperience(experience)
    }
    fun deleteData(obj: Experience){
        experienceDao.delete(obj)
    }

    fun updateData(obj: Experience){
        experienceDao.updateData(obj)
    }

    fun readAllDat(id:String):LiveData<List<Experience>>{
        return experienceDao.readAllData(id)
    }
}