package com.example.resumemaker.experience

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
import com.example.resumemaker.objectives.*
import com.example.resumemaker.skills.SkillsFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ExperienceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExperienceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private lateinit var experienceViewModelForWriting: ExperienceViewModelForWriting
    private lateinit var titleEt: EditText
    private lateinit var companyEt: EditText
    private lateinit var startDateEt: EditText
    private lateinit var endDateEt: EditText
    private lateinit var detailsEt: EditText
    private lateinit var cityEt: EditText
    private lateinit var save: Button
    private var companyDetails:String=""


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
        var v:View= inflater.inflate(R.layout.fragment_experience, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        save.setOnClickListener{

            if(TextUtils.isEmpty(titleEt.text.toString())){
                Toast.makeText(context,"Title should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(companyEt.text.toString())){
                Toast.makeText(context,"Company Name should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(cityEt.text.toString())){
                Toast.makeText(context,"City Name should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(startDateEt.text.toString())){
                Toast.makeText(context,"Start Date should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(endDateEt.text.toString())){
                Toast.makeText(context,"End Date should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(TextUtils.isEmpty(detailsEt.text.toString())){
                    companyDetails="empty"
                }
                else{
                    companyDetails=detailsEt.text.toString()
                }
                if(param1!=null){
                    var experience= Experience(0,titleEt.text.toString(),companyEt.text.toString(),cityEt.text.toString(),startDateEt.text.toString(),endDateEt.text.toString(),companyDetails,
                        param1!!
                    )
                    experienceViewModelForWriting.addExperience(experience)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    var fragment=SkillsFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }

            }


        }
    }

    private fun findIds(v: View) {
        titleEt =v.findViewById(R.id.experience_title)
        companyEt =v.findViewById(R.id.experience_company)
        cityEt =v.findViewById(R.id.experience_city)
        startDateEt =v.findViewById(R.id.experience_start_date)
        endDateEt =v.findViewById(R.id.experience_end_date)
        detailsEt =v.findViewById(R.id.experience_detail)
        save=v.findViewById(R.id.save_and_next_from_experience)
        experienceViewModelForWriting = ViewModelProvider(this).get(ExperienceViewModelForWriting::class.java)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ExperienceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}