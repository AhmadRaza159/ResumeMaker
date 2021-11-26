package com.example.resumemaker.hobbies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceRepository
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HobbyViewModel  (application: Application): AndroidViewModel(application) {
    private val repository: HobbyRepository

    init {
        val hobbyDao = BasicInfoDatabase.getDatabase(application).hobbyDao()
        repository = HobbyRepository(hobbyDao)
    }
    fun getSpecificObj(id: String): LiveData<List<Hobby>>{
        return repository.readAllDat(id)
    }

    fun deleteData(obj: Hobby){
        repository.deleteData(obj)
    }
    fun addHobby(hobby: Hobby){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHobby(hobby)
        }
    }
    fun updateData(obj: Hobby){
        repository.updateData(obj)
    }

}