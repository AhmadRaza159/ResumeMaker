package com.example.resumemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.achivements.AchivementViewModelForReading
import com.example.resumemaker.achivements.AchivementViewModelForWriting
import com.example.resumemaker.educations.Education
import com.example.resumemaker.educations.EducationViewModelForReading
import com.example.resumemaker.educations.EducationViewModelForWriting
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceViewModelForReading
import com.example.resumemaker.experience.ExperienceViewModelForWriting
import com.example.resumemaker.languages.Language
import com.example.resumemaker.languages.LanguageViewModelForReading
import com.example.resumemaker.languages.LanguageViewModelForWriting
import com.example.resumemaker.objectives.Objective
import com.example.resumemaker.objectives.ObjectiveViewModelForReading
import com.example.resumemaker.objectives.ObjectiveViewModelForWriting
import com.example.resumemaker.profile.BasicDataViewModel
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.projects.Project
import com.example.resumemaker.projects.ProjectViewModelForReading
import com.example.resumemaker.projects.ProjectViewModelForWriting
import com.example.resumemaker.referances.Referance
import com.example.resumemaker.referances.ReferanceViewModelForReading
import com.example.resumemaker.referances.ReferanceViewModelForWriting
import com.example.resumemaker.skills.Skill
import com.example.resumemaker.skills.SkillViewModelForReading
import com.example.resumemaker.skills.SkillViewModelForWriting
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var basicDataViewModel: BasicDataViewModel
    private lateinit var objectiveViewModelForReading: ObjectiveViewModelForReading
    private lateinit var experienceViewModelForReading: ExperienceViewModelForReading
    private lateinit var skillViewModelForReading: SkillViewModelForReading
    private lateinit var educationViewModelForReading: EducationViewModelForReading
    private lateinit var projectViewModelForReading: ProjectViewModelForReading
    private lateinit var achivementViewModelForReading: AchivementViewModelForReading
    private lateinit var languageViewModelForReading: LanguageViewModelForReading
    private lateinit var referanceViewModelForReading: ReferanceViewModelForReading

    private lateinit var referanceViewModelForWriting: ReferanceViewModelForWriting
    private lateinit var languageViewModelForWriting: LanguageViewModelForWriting
    private lateinit var achivementViewModelForWriting: AchivementViewModelForWriting
    private lateinit var projectViewModelForWriting: ProjectViewModelForWriting
    private lateinit var educationViewModelForWriting: EducationViewModelForWriting
    private lateinit var skillViewModelForWriting: SkillViewModelForWriting
    private lateinit var experienceViewModelForWriting: ExperienceViewModelForWriting
    private lateinit var objectiveViewModelForWriting: ObjectiveViewModelForWriting

    lateinit var adapter:ProfileAdapter

    lateinit var addProfileButton:FloatingActionButton
    lateinit var recyclerview: RecyclerView
    var listOfProfile= ArrayList<BasicInfo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findIds()
        factory()
    }

    private fun factory() {
        addProfileButton.setOnClickListener{
            var intent= Intent(this,AddResumeActivity::class.java)
            startActivity(intent)

        }

        basicDataViewModel.readAllData.observe(this, Observer { basicInfo->
            for(value in basicInfo){
                listOfProfile.add(value)
            }
            adapter=ProfileAdapter(listOfProfile, object : MyInterfaceForView{
                override fun onClick(obj1: BasicInfo) {
                    var listOfObjectivesObj=ArrayList<Objective>()
                    var listOfExperiencesObj=ArrayList<Experience>()
                    var listOfSkillsObj=ArrayList<Skill>()
                    var listOfEducationsObj=ArrayList<Education>()
                    var listOfProjectsObj=ArrayList<Project>()
                    var listOfAchivementsObj=ArrayList<Achivement>()
                    var listOfLanguagesObj=ArrayList<Language>()
                    var listOfReferancesObj=ArrayList<Referance>()

                    reInitializeViewModels(obj1.id)
                    objectiveViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            listOfObjectivesObj.add(i)
                        }
                        experienceViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                            for(i in obj){
                                listOfExperiencesObj.add(i)
                            }
                            skillViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                for(i in obj){
                                    listOfSkillsObj.add(i)
                                }
                                educationViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                    for(i in obj){
                                        listOfEducationsObj.add(i)
                                    }
                                    projectViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                        for(i in obj){
                                            listOfProjectsObj.add(i)
                                        }
                                        achivementViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                            for(i in obj){
                                                listOfAchivementsObj.add(i)
                                            }
                                            languageViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                                for(i in obj){
                                                    listOfLanguagesObj.add(i)
                                                }
                                                referanceViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                                                    for(i in obj){
                                                        listOfReferancesObj.add(i)
                                                    }
                                                    var intent=Intent(this@MainActivity, ViewResumeActivity::class.java)
                                                    println("ist ${listOfExperiencesObj.size}")
                                                    intent.putExtra("basicinfo",obj1)
                                                    intent.putExtra("objective",listOfObjectivesObj)
                                                    intent.putExtra("experience", listOfExperiencesObj)
                                                    intent.putExtra("skill", listOfSkillsObj)
                                                    intent.putExtra("education", listOfEducationsObj)
                                                    intent.putExtra("project", listOfProjectsObj)
                                                    intent.putExtra("achivement",listOfAchivementsObj)
                                                    intent.putExtra("language",listOfLanguagesObj)
                                                    intent.putExtra("referance",listOfReferancesObj)

                                                    startActivity(intent)

                                                })

                                            })

                                        })

                                    })

                                })
                            })
                        })
                    })















                    //startActivity(Intent(this@MainActivity, MainActivity::class.java))

                    //finish()



                }
            }, object: MyInterfaceForDelete{
                override fun onClick(obj: BasicInfo) {
                    //delete selected  item
                    reInitializeViewModels(obj.id)

                    referanceViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            referanceViewModelForWriting.deleteReferance(i)
                        }

                    })

                    languageViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            languageViewModelForWriting.deleteData(i)
                        }

                    })

                    achivementViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            achivementViewModelForWriting.deleteData(i)
                        }

                    })



                    projectViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            projectViewModelForWriting.deleteData(i)
                        }

                    })

                    educationViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            educationViewModelForWriting.deleteData(i)
                        }

                    })

                    skillViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            skillViewModelForWriting.deleteData(i)
                        }

                    })

                    experienceViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            experienceViewModelForWriting.deleteData(i)
                        }

                    })

                    objectiveViewModelForReading.readAllData.observe(this@MainActivity,Observer{ obj->
                        for(i in obj){
                            objectiveViewModelForWriting.deleteData(i)
                        }

                    })

                    basicDataViewModel.deleteData(obj)
                    listOfProfile.remove(obj)
                    adapter.profileList=listOfProfile
                    adapter.notifyDataSetChanged()


                }

            })
            recyclerview.adapter=adapter

        })


    }

    private fun findIds() {
        basicDataViewModel= ViewModelProvider(this).get(BasicDataViewModel::class.java)
        referanceViewModelForWriting= ViewModelProvider(this).get(ReferanceViewModelForWriting::class.java)
        languageViewModelForWriting= ViewModelProvider(this).get(LanguageViewModelForWriting::class.java)
        achivementViewModelForWriting= ViewModelProvider(this).get(AchivementViewModelForWriting::class.java)
        projectViewModelForWriting= ViewModelProvider(this).get(ProjectViewModelForWriting::class.java)
        educationViewModelForWriting= ViewModelProvider(this).get(EducationViewModelForWriting::class.java)
        skillViewModelForWriting= ViewModelProvider(this).get(SkillViewModelForWriting::class.java)
        experienceViewModelForWriting= ViewModelProvider(this).get(ExperienceViewModelForWriting::class.java)
        objectiveViewModelForWriting= ViewModelProvider(this).get(ObjectiveViewModelForWriting::class.java)
        referanceViewModelForWriting= ViewModelProvider(this).get(ReferanceViewModelForWriting::class.java)

        //objectiveViewModel= ViewModelProvider(this).get(ObjectiveViewModel::class.java)


        addProfileButton=findViewById(R.id.add_new_resume)

        recyclerview=findViewById(R.id.recycler_view_of_profiles)
        recyclerview.layoutManager= GridLayoutManager(applicationContext,1)
    }

    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }

    private fun reInitializeViewModels(id:String){
        objectiveViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { ObjectiveViewModelForReading(application,id) }
        ).get(ObjectiveViewModelForReading::class.java)

        //////////

        experienceViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { ExperienceViewModelForReading(application,id) }
        ).get(ExperienceViewModelForReading::class.java)


        //////////

        skillViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { SkillViewModelForReading(application,id) }
        ).get(SkillViewModelForReading::class.java)


        //////////

        educationViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { EducationViewModelForReading(application,id) }
        ).get(EducationViewModelForReading::class.java)


        //////////

        projectViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { ProjectViewModelForReading(application,id) }
        ).get(ProjectViewModelForReading::class.java)


        //////////

        achivementViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { AchivementViewModelForReading(application,id) }
        ).get(AchivementViewModelForReading::class.java)


        //////////

        languageViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { LanguageViewModelForReading(application,id) }
        ).get(LanguageViewModelForReading::class.java)


        //////////

        referanceViewModelForReading = ViewModelProviders.of(
            this,
            viewModelFactory { ReferanceViewModelForReading(application,id) }
        ).get(ReferanceViewModelForReading::class.java)


    }

}