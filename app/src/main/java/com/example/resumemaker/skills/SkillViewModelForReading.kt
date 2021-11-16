package com.example.resumemaker.skills

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SkillViewModelForReading  (application: Application,id:String): AndroidViewModel(application){
    val readAllData: LiveData<List<Skill>>
    private val repository: SkillRepository

    init {
        val skillDao = BasicInfoDatabase.getDatabase(application).skillDao()
        repository = SkillRepository(skillDao,id)
        readAllData = repository.readAllData
    }
}