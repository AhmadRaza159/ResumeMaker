package com.example.resumemaker.hobbies

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
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceViewModelForWriting
import com.example.resumemaker.referances.ReferanceFragment
import com.example.resumemaker.skills.SkillsFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [HobbyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HobbyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var hobbyViewModel: HobbyViewModel
    private lateinit var save: Button
    private lateinit var addMore: Button
    private lateinit var titleEt: EditText



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
        var v:View= inflater.inflate(R.layout.fragment_hobby, container, false)
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

            else{

                if(param1!=null){
                    var hobby= Hobby(0,titleEt.text.toString(),
                        param1!!
                    )
                    hobbyViewModel.addHobby(hobby)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    var fragment= ReferanceFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }
            }
        }
        addMore.setOnClickListener{
            if(TextUtils.isEmpty(titleEt.text.toString())){
                Toast.makeText(context,"Hobby title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{

                if(param1!=null){
                    var hobby= Hobby(0,titleEt.text.toString(),
                        param1!!
                    )
                    hobbyViewModel.addHobby(hobby)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    titleEt.setText("")

                }
            }
        }
    }
    private fun findIds(v: View) {
        addMore=v.findViewById(R.id.experience_add_more)
        titleEt =v.findViewById(R.id.experience_title)
        save=v.findViewById(R.id.save_and_next_from_experience)
        hobbyViewModel = ViewModelProvider(this).get(HobbyViewModel::class.java)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HobbyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            HobbyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}