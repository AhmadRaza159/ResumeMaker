package com.example.resumemaker.skills

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.R
import com.example.resumemaker.educations.EducationFragment
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceAdapter

private const val ARG_PARAM1 = "param1"

class SkillsFragment : Fragment() {
    private var param1: String? = null

    private lateinit var mSkillViewModel: SkillViewModelForWriting
    private lateinit var titleEt: EditText
    private lateinit var newItemDialog: Dialog
    private lateinit var save: ImageButton
    private lateinit var addMore: ImageButton
    private lateinit var next: ImageButton
    private lateinit var poorButton: Button
    private lateinit var goodButton: Button
    private lateinit var excellentButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SkillAdapter
    private var listData = ArrayList<Skill>()

    private var code: String = "add"
    private var skillLevel: String = ""
    private var idSkill: Int = 0


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
        var v: View = inflater.inflate(R.layout.fragment_skills, container, false)
        findIds(v)
        factory()
        return v
    }


    private fun factory() {
        mSkillViewModel.getSpecificObj(param1!!).observe(requireActivity(), Observer { obj ->
            if (listData.size != 0) {
                listData.clear()
            }
            for (i in obj) {
                listData.add(i)
            }
            adapter = SkillAdapter(listData, object : SkillInterfaceAdapter {
                override fun onClick(obj: Skill) {
                    code = "edit"
                    idSkill = obj.id
                    newItemDialog.show()
                    titleEt.setText(obj.title)
                    if (obj.expLevel.equals("Poor")){
                        poorButton.setBackgroundColor(Color.BLUE)
                        goodButton.setBackgroundColor(Color.GRAY)
                        excellentButton.setBackgroundColor(Color.GRAY)
                        skillLevel="Poor"
                    }
                    else if(obj.expLevel.equals("Good")){
                        poorButton.setBackgroundColor(Color.GRAY)
                        goodButton.setBackgroundColor(Color.BLUE)
                        excellentButton.setBackgroundColor(Color.GRAY)
                        skillLevel="Good"
                    }
                    else if(obj.expLevel.equals("Excellent")){
                        poorButton.setBackgroundColor(Color.GRAY)
                        goodButton.setBackgroundColor(Color.GRAY)
                        excellentButton.setBackgroundColor(Color.BLUE)
                        skillLevel="Excellent"
                    }
                }

            },object : SkillInterfaceAdapter{
                override fun onClick(obj: Skill) {
                    mSkillViewModel.deleteData(obj)
                }

            })
            recyclerView.adapter = adapter

        })

        ///////////////////

        poorButton.setOnClickListener{
            poorButton.setBackgroundColor(Color.BLUE)
            goodButton.setBackgroundColor(Color.GRAY)
            excellentButton.setBackgroundColor(Color.GRAY)
            skillLevel="Poor"
        }

        /////////////////
        goodButton.setOnClickListener{
            poorButton.setBackgroundColor(Color.GRAY)
            goodButton.setBackgroundColor(Color.BLUE)
            excellentButton.setBackgroundColor(Color.GRAY)
            skillLevel="Good"
        }

        /////////////////////
        excellentButton.setOnClickListener{
            poorButton.setBackgroundColor(Color.GRAY)
            goodButton.setBackgroundColor(Color.GRAY)
            excellentButton.setBackgroundColor(Color.BLUE)
            skillLevel="Excellent"
        }

        ////////////////////////////

        save.setOnClickListener {

            if (TextUtils.isEmpty(titleEt.text.toString())) {
                Toast.makeText(context, "Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(skillLevel)) {
                Toast.makeText(context, "Skill level should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                if (code.equals("add")) {
                    var skill = Skill(
                        0, titleEt.text.toString(), skillLevel,
                        param1!!
                    )
                    mSkillViewModel.addSkills(skill)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()

                } else {

                    var skill = Skill(
                        idSkill, titleEt.text.toString(), skillLevel,
                        param1!!
                    )
                    mSkillViewModel.updateData(skill)

                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()

                }

            }


        }

        next.setOnClickListener {
            var fragment = EducationFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }

        addMore.setOnClickListener {
            code="add"
            poorButton.setBackgroundColor(Color.GRAY)
            goodButton.setBackgroundColor(Color.GRAY)
            excellentButton.setBackgroundColor(Color.GRAY)
            skillLevel=""
            titleEt.setText("")
            newItemDialog.show()
            /* if(TextUtils.isEmpty(titleEt.text.toString())){
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
                     titleEt.setText("")
                     levelEt.setText("")

                 }

             }

 */
        }
    }

    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.skill_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_skill_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        titleEt = newItemDialog.findViewById(R.id.skill_title)
        poorButton = newItemDialog.findViewById(R.id.skill_poor)
        goodButton = newItemDialog.findViewById(R.id.skill_good)
        excellentButton = newItemDialog.findViewById(R.id.skill_excellent)
        save = newItemDialog.findViewById(R.id.skill_save)
        next = v.findViewById(R.id.skill_done)
        addMore = v.findViewById(R.id.skill_add_more)

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