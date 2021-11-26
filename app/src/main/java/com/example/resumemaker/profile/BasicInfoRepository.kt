package com.example.resumemaker.profile

import androidx.lifecycle.LiveData

class BasicInfoRepository(private val basicInfoDao: BasicInfoDao) {
    val readAllData: LiveData<List<BasicInfo>> = basicInfoDao.readAllData()

    suspend fun addBasicInfo(basicInfo: BasicInfo){
        basicInfoDao.addBasicInfo(basicInfo)

    }
    fun updateData(obj: BasicInfo){
        basicInfoDao.updateData(obj)
    }

    fun deleteData(obj: BasicInfo){
        basicInfoDao.delete(obj)
    }
}