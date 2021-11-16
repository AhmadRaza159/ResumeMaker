package com.example.resumemaker.projects

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

class ProjectViewModelForWriting (application: Application): AndroidViewModel(application){
    private val repository: ProjectRepository

    init {
        val projectDao = BasicInfoDatabase.getDatabase(application).projectDao()
        repository = ProjectRepository(projectDao,"nill")
    }

    fun addProject(project: Project){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProject(project)
        }
    }

    fun deleteData(obj: Project){
        repository.deleteData(obj)
    }
}