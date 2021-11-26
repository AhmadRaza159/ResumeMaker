package com.example.resumemaker.objectives

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.profile.BasicInfo

class ObjectiveRepository(private val objectivesDao: ObjectivesDao, private var id:String) {
    val readAllData: LiveData<List<Objective>> = objectivesDao.readAllData(id)

    suspend fun addObjective(objective: Objective){
        objectivesDao.addObjective(objective)
    }

    fun deleteData(obj: Objective){
        objectivesDao.delete(obj)
    }

    fun updateData(obj: Objective){
        objectivesDao.updateData(obj)
    }

    fun readAllDat(id:String):LiveData<List<Objective>>{
        return objectivesDao.readAllData(id)
    }
}