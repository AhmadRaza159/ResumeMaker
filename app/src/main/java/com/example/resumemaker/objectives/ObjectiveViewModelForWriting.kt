package com.example.resumemaker.objectives

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjectiveViewModelForWriting(application: Application): AndroidViewModel(application) {
    private val repository: ObjectiveRepository
    init {
        val objectiveDao = BasicInfoDatabase.getDatabase(application).objectiveDao()
        repository = ObjectiveRepository(objectiveDao,"nill")
    }
    fun addObjective(objective: Objective){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addObjective(objective)
        }
    }
    fun deleteData(obj: Objective){
        repository.deleteData(obj)
    }
}