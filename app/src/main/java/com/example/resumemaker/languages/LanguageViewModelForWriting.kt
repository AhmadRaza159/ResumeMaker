package com.example.resumemaker.languages

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

class LanguageViewModelForWriting(application: Application): AndroidViewModel(application) {
    private val repository: LanguageRepository

    init {
        val languageDao = BasicInfoDatabase.getDatabase(application).languageDaao()
        repository = LanguageRepository(languageDao,"nill")
    }
    fun deleteData(obj: Language){
        repository.deleteData(obj)
    }
    fun addLanguage(language: Language){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLanguage(language)
        }
    }
}