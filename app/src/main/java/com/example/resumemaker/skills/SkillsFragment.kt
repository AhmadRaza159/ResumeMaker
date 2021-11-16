package com.example.resumemaker.skills

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.resumemaker.R
import com.example.resumemaker.educations.EducationFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
class SkillsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var mSkillViewModel: SkillViewModelForWriting
    private lateinit var titleEt: EditText
    private lateinit var levelEt: EditText

    private lateinit var save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View= inflater.inflate(R.layout.fragment_skills, container, false)
        findIds(v)
        factory()
        return v
    }


    private fun factory() {
        save.setOnClickListener{

            if(TextUtils.isEmpty(titleEt.text.toString())){
                Toast.makeText(context,"Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(levelEt.text.toString())){
                Toast.makeText(context,"Skill level should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(param1!=null){
                    var skill= Skill(0,titleEt.text.toString(),levelEt.text.toString(),
                        param1!!
                    )
                    mSkillViewModel.addSkills(skill)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    var fragment=EducationFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }

            }


        }
    }

    private fun findIds(v: View) {
        titleEt =v.findViewById(R.id.skill_title)
        levelEt =v.findViewById(R.id.skill_level)
        save=v.findViewById(R.id.save_and_next_from_skill)

        mSkillViewModel = ViewModelProvider(this).get(SkillViewModelForWriting::class.java)
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            SkillsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}