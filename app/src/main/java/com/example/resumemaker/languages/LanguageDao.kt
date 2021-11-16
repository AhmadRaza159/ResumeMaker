package com.example.resumemaker.languages

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.skills.Skill

@Dao
interface LanguageDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addLanguage(language: Language)
    @Query("SELECT * FROM language_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Language>>

    @Delete
    fun delete(model:Language)
}