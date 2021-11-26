package com.example.resumemaker.skills

import androidx.lifecycle.LiveData
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.objectives.ObjectivesDao

class SkillRepository(private val skillDao: SkillDao, private val id:String) {
    val readAllData: LiveData<List<Skill>> = skillDao.readAllData(id)

    suspend fun addSkill(skill: Skill){
        skillDao.addSkills(skill)
    }
    fun deleteData(obj: Skill){
        skillDao.delete(obj)
    }

    fun updateData(obj: Skill){
        skillDao.updateData(obj)
    }

    fun readAllDat(id:String):LiveData<List<Skill>>{
        return skillDao.readAllData(id)
    }
}