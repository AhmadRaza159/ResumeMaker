package com.example.resumemaker.referances

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReferanceViewModelForReading  (application: Application, id:String): AndroidViewModel(application) {
    val readAllData: LiveData<List<Referance>>
    private val repository: ReferanceRepository

    init {
        val referanceDao = BasicInfoDatabase.getDatabase(application).referanceDao()
        repository = ReferanceRepository(referanceDao,id)
        readAllData = repository.readAllData
    }


}