package com.example.resumemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.educations.Education
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.languages.Language
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.skills.Skill

class ViewResumeActivity : AppCompatActivity() {
    lateinit var template1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_resume)

        findIds()

        val basicInfo = intent.getParcelableExtra<BasicInfo>("basicinfo")
        val objective=intent.getParcelableArrayListExtra<Objective>("objective")
        val experience=intent.getParcelableArrayListExtra<Experience>("experience")
        val skill=intent.getParcelableArrayListExtra<Skill>("skill")
        val education=intent.getParcelableArrayListExtra<Education>("education")
        val project=intent.getParcelableArrayListExtra<Project>("project")
        val achivement=intent.getParcelableArrayListExtra<Achivement>("achivement")
        val language=intent.getParcelableArrayListExtra<Language>("language")
        val referance=intent.getParcelableArrayListExtra<Referance>("referance")

        println("Its second activity, ")
        println(basicInfo)
        if (objective != null&&experience != null&&skill != null&&education != null&&project != null&&achivement != null&&language != null&&referance!=null) {
            println(objective)
            println(experience)
            println(skill)
            println(education)
            println(project)
            println(achivement)
            println(language)
            println(referance)
        }
    }

    private fun findIds() {
        template1=findViewById(R.id.view_resume_template1)
    }
}