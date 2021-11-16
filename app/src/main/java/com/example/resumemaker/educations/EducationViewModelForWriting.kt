package com.example.resumemaker.educations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.profile.BasicInfoDatabase
import com.example.resumemaker.skills.Skill
import com.example.resumemaker.skills.SkillRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EducationViewModelForWriting(application: Application): AndroidViewModel(application) {
    private val repository: EducationRepository

    init {
        val educationDao = BasicInfoDatabase.getDatabase(application).educationDao()
        repository = EducationRepository(educationDao,"nill")
    }
    fun deleteData(obj: Education){
        repository.deleteData(obj)
    }
    fun addEducation(education: Education){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEducation(education)
        }
    }
}