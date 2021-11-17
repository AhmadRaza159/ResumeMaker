package com.example.resumemaker.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.achivements.AchivementDao
import com.example.resumemaker.educations.Education
import com.example.resumemaker.educations.EducationDao
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceDao
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.hobbies.HobbyDao
import com.example.resumemaker.languages.Language
import com.example.resumemaker.languages.LanguageDao
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.objectives.ObjectivesDao
import com.example.resumemaker.projects.Project
import com.example.resumemaker.projects.ProjectDao
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.referances.ReferanceDao
import com.example.resumemaker.skills.Skill
import com.example.resumemaker.skills.SkillDao

@Database(entities = [BasicInfo::class, Objective::class, Experience::class, Skill::class, Education::class, Project::class, Achivement::class, Language::class, Referance::class, Hobby::class], version = 1, exportSchema = false)
abstract class BasicInfoDatabase : RoomDatabase(){
    abstract fun basicInfoDao(): BasicInfoDao
    abstract fun objectiveDao(): ObjectivesDao
    abstract fun experienceDao(): ExperienceDao
    abstract fun skillDao(): SkillDao
    abstract fun educationDao(): EducationDao
    abstract fun projectDao(): ProjectDao
    abstract fun achivementDao(): AchivementDao
    abstract fun languageDaao(): LanguageDao
    abstract fun referanceDao(): ReferanceDao
    abstract fun hobbyDao(): HobbyDao


    companion object {
        @Volatile
        private var INSTANCE: BasicInfoDatabase? = null

        fun getDatabase(context: Context): BasicInfoDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BasicInfoDatabase::class.java,
                    "basic_info_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}