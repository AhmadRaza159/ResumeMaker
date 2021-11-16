package com.example.resumemaker.languages

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.profile.BasicInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LanguageViewModelForReading (application: Application, id:String): AndroidViewModel(application) {
    val readAllData: LiveData<List<Language>>
    private val repository: LanguageRepository

    init {
        val languageDao = BasicInfoDatabase.getDatabase(application).languageDaao()
        repository = LanguageRepository(languageDao,id)
        readAllData = repository.readAllData
    }

}