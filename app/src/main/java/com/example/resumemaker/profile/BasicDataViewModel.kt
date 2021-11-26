package com.example.resumemaker.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasicDataViewModel (application: Application): AndroidViewModel(application){
    val readAllData: LiveData<List<BasicInfo>>
    private val repository: BasicInfoRepository

    init {
        val basicInfoDao = BasicInfoDatabase.getDatabase(application).basicInfoDao()
        repository = BasicInfoRepository(basicInfoDao)
        readAllData = repository.readAllData
    }

    fun addBasicInfo(basicInfo: BasicInfo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBasicInfo(basicInfo)
        }
    }

    fun updateData(obj: BasicInfo){
        repository.updateData(obj)
    }

    fun deleteData(obj: BasicInfo){
        repository.deleteData(obj)
    }
}