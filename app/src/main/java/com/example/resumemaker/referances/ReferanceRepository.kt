package com.example.resumemaker.referances

import androidx.lifecycle.LiveData
import com.example.resumemaker.skills.Skill

class ReferanceRepository(private val referanceDao: ReferanceDao, private val id:String) {
    val readAllData: LiveData<List<Referance>> = referanceDao.readAllData(id)
    fun deleteData(obj:Referance){
        referanceDao.delete(obj)
    }

    suspend fun addReferance(referance: Referance){
        referanceDao.addReferance(referance)
    }
}