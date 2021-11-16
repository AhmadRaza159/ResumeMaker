package com.example.resumemaker.achivements

import androidx.lifecycle.LiveData
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance

class AchivementRepository(private val achivementDao: AchivementDao, private val id:String) {
    val readAllData: LiveData<List<Achivement>> = achivementDao.readAllData(id)
    fun deleteData(obj: Achivement){
        achivementDao.delete(obj)
    }

    suspend fun addAchivement(achivement: Achivement){
        achivementDao.addAchivement(achivement)
    }
}