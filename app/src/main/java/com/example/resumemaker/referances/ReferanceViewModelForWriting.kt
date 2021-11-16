package com.example.resumemaker.referances

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import com.example.resumemaker.skills.Skill
import com.example.resumemaker.skills.SkillRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.ref.Reference

class ReferanceViewModelForWriting (application: Application): AndroidViewModel(application) {
    private val repository: ReferanceRepository

    init {
        val referanceDao = BasicInfoDatabase.getDatabase(application).referanceDao()
        repository = ReferanceRepository(referanceDao,"nill")
    }

    fun addReference(referance: Referance){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addReferance(referance)
        }
    }

    fun deleteReferance(obj: Referance){
       repository.deleteData(obj)
    }
}