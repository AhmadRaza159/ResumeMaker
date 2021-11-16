package com.example.resumemaker.objectives

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.profile.BasicInfoDatabase
import com.example.resumemaker.profile.BasicInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjectiveViewModelForReading(application: Application, id:String): AndroidViewModel(application) {

    val readAllData: LiveData<List<Objective>>
    private val repository: ObjectiveRepository
    init {
        val objectiveDao = BasicInfoDatabase.getDatabase(application).objectiveDao()
        repository = ObjectiveRepository(objectiveDao,id)
        readAllData = repository.readAllData
    }
}