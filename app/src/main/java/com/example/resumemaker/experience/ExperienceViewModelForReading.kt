package com.example.resumemaker.experience

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExperienceViewModelForReading (application: Application, id:String): AndroidViewModel(application) {
    val readAllData: LiveData<List<Experience>>
    private val repository: ExperienceRepository

    init {
        val experienceDao = BasicInfoDatabase.getDatabase(application).experienceDao()
        repository = ExperienceRepository(experienceDao,id)
        readAllData = repository.readAllData
    }

}