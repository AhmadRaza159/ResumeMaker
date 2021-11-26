package com.example.resumemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.educations.Education
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.languages.Language
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.skills.Skill

class ViewTemplatesActivity : AppCompatActivity() {
    lateinit var buttonTemplate1:ImageButton
    lateinit var buttonTemplate2:ImageButton
    lateinit var buttonTemplate3:ImageButton
    lateinit var buttonTemplate4:ImageButton
    lateinit var generateResume: GenerateResume

    lateinit var basicInfo:BasicInfo
    lateinit var objectives:ArrayList<Objective>
    lateinit var skills:ArrayList<Skill>
    lateinit var experiences:ArrayList<Experience>
    lateinit var educations:ArrayList<Education>
    lateinit var projects:ArrayList<Project>
    lateinit var achivements:ArrayList<Achivement>
    lateinit var languages:ArrayList<Language>
    lateinit var hobbies:ArrayList<Hobby>
    lateinit var referances:ArrayList<Referance>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_template)

        findIds()

        basicInfo = intent.getParcelableExtra<BasicInfo>("basicinfo")!!
        objectives=intent.getParcelableArrayListExtra<Objective>("objective")!!
        experiences=intent.getParcelableArrayListExtra<Experience>("experience")!!
        skills=intent.getParcelableArrayListExtra<Skill>("skill")!!
        educations=intent.getParcelableArrayListExtra<Education>("education")!!
        projects=intent.getParcelableArrayListExtra<Project>("project")!!
        achivements=intent.getParcelableArrayListExtra<Achivement>("achivement")!!
        languages=intent.getParcelableArrayListExtra<Language>("language")!!
        hobbies=intent.getParcelableArrayListExtra<Hobby>("hobby")!!
        referances=intent.getParcelableArrayListExtra<Referance>("referance")!!

        println("nnn "+objectives.size)
        generateResume=GenerateResume(basicInfo,objectives,experiences,skills,educations,projects,achivements,languages,referances,hobbies)

        factory()
    }

    private fun factory() {
        buttonTemplate1.setOnClickListener{
            var s:String=generateResume.template1()
            var intent= Intent(this,ViewResumeActivity::class.java)
            intent.putExtra("html",s)
            intent.putExtra("name",basicInfo.name)
            startActivity(intent)
        }
        buttonTemplate2.setOnClickListener{
            var s:String=generateResume.template2()
            var intent= Intent(this,ViewResumeActivity::class.java)
            intent.putExtra("html",s)
            intent.putExtra("name",basicInfo.name)
            startActivity(intent)
        }
        buttonTemplate3.setOnClickListener{
            var s:String=generateResume.template3()
            var intent= Intent(this,ViewResumeActivity::class.java)
            intent.putExtra("html",s)
            intent.putExtra("name",basicInfo.name)
            startActivity(intent)
        }
        buttonTemplate4.setOnClickListener{
            var s:String=generateResume.template4()
            var intent= Intent(this,ViewResumeActivity::class.java)
            intent.putExtra("html",s)
            intent.putExtra("name",basicInfo.name)
            startActivity(intent)
        }
    }

    private fun findIds() {
        buttonTemplate4=findViewById(R.id.view_resume_template4)
        buttonTemplate3=findViewById(R.id.view_resume_template3)
        buttonTemplate2=findViewById(R.id.view_resume_template2)
        buttonTemplate1=findViewById(R.id.view_resume_template1)
    }

}