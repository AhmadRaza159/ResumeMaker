package com.example.resumemaker

import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.educations.Education
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.languages.Language
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.skills.Skill

class GenerateResume(val basicInfo:BasicInfo, val objective: Objective, val experiences:ArrayList<Experience>, val skills:ArrayList<Skill>, val educations:ArrayList<Education>, val projects:ArrayList<Project>, val achivements:ArrayList<Achivement>, val languages:ArrayList<Language>, val references:ArrayList<Referance>,) {
    fun template():String{
        var htmlCode:String=""

        return htmlCode

    }
}