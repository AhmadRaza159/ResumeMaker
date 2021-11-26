package com.example.resumemaker.hobbies

import androidx.lifecycle.LiveData
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceDao
import com.example.resumemaker.skills.Skill

class HobbyRepository (private val hobbyDao: HobbyDao) {
    //val readAllData: LiveData<List<Hobby>> = hobbyDao.readAllData(id)
    fun readAllDat(id:String):LiveData<List<Hobby>>{
        return hobbyDao.readAllData(id)
    }
    suspend fun addHobby(hobby: Hobby){
        hobbyDao.addHobby(hobby)
    }
    fun deleteData(obj: Hobby){
        hobbyDao.delete(obj)
    }

    fun updateData(obj: Hobby){
        hobbyDao.updateData(obj)
    }
}