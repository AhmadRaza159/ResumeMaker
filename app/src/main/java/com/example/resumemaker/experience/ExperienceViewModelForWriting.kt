package com.example.resumemaker.experience

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExperienceViewModelForWriting(application: Application): AndroidViewModel(application) {
    private val repository: ExperienceRepository

    init {
        val experienceDao = BasicInfoDatabase.getDatabase(application).experienceDao()
        repository = ExperienceRepository(experienceDao,"nill")
    }
    fun deleteData(obj: Experience){
        repository.deleteData(obj)
    }
    fun addExperience(experience: Experience){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExperience(experience)
        }
    }
}