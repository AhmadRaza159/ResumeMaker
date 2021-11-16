package com.example.resumemaker.projects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectViewModelForReading (application: Application, id:String): AndroidViewModel(application){
    val readAllData: LiveData<List<Project>>
    private val repository: ProjectRepository

    init {
        val projectDao = BasicInfoDatabase.getDatabase(application).projectDao()
        repository = ProjectRepository(projectDao,id)
        readAllData = repository.readAllData
    }

}