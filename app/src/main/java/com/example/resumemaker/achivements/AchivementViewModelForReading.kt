package com.example.resumemaker.achivements

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import com.example.resumemaker.projects.Project
import com.example.resumemaker.projects.ProjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchivementViewModelForReading  (application: Application,id:String): AndroidViewModel(application) {
    val readAllData: LiveData<List<Achivement>>
    private val repository: AchivementRepository

    init {
        val achivementDao = BasicInfoDatabase.getDatabase(application).achivementDao()
        repository = AchivementRepository(achivementDao,id)
        readAllData = repository.readAllData
    }

}