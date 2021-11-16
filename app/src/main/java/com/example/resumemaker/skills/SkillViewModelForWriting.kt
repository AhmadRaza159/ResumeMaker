package com.example.resumemaker.skills

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.objectives.ObjectiveRepository
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SkillViewModelForWriting (application: Application): AndroidViewModel(application){
    private val repository: SkillRepository

    init {
        val skillDao = BasicInfoDatabase.getDatabase(application).skillDao()
        repository = SkillRepository(skillDao,"nill")
    }

    fun deleteData(obj: Skill){
        repository.deleteData(obj)
    }

    fun addSkills(skill: Skill){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSkill(skill)
        }
    }
}