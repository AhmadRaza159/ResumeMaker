package com.example.resumemaker.languages

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.skills.Skill

class LanguageRepository(private val languageDao: LanguageDao, private val id:String) {
    val readAllData: LiveData<List<Language>> = languageDao.readAllData(id)
    suspend fun addLanguage(language: Language){
        languageDao.addLanguage(language)
    }

    fun deleteData(obj: Language){
        languageDao.delete(obj)
    }
}