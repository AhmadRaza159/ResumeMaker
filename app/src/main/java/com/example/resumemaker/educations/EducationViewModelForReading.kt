package com.example.resumemaker.educations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EducationViewModelForReading(application: Application,id:String): AndroidViewModel(application) {
    val readAllData: LiveData<List<Education>>
    private val repository: EducationRepository

    init {
        val educationDao = BasicInfoDatabase.getDatabase(application).educationDao()
        repository = EducationRepository(educationDao,id)
        readAllData = repository.readAllData
    }


}