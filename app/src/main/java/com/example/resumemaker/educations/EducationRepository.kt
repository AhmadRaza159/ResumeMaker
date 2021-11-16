package com.example.resumemaker.educations

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.skills.Skill

class EducationRepository(private val educationDao:EducationDao, private val id:String) {
    val readAllData: LiveData<List<Education>> = educationDao.readAllData(id)
    fun deleteData(obj: Education){
        educationDao.delete(obj)
    }

    suspend fun addEducation(education: Education){
        educationDao.addEducation(education)
    }
}