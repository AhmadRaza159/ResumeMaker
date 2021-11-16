package com.example.resumemaker.profile

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
import com.example.resumemaker.objectives.ObjectivesFragment
import com.example.resumemaker.profile.BasicDataViewModel
import com.example.resumemaker.profile.BasicInfo
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasicInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasicInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var mBasicSalaryViewModel:BasicDataViewModel
    private lateinit var nameEt:EditText
    private lateinit var desigEt:EditText
    private lateinit var addressEt:EditText
    private lateinit var githubEt:EditText
    private lateinit var linkedinEt:EditText
    private lateinit var gmailEt:EditText
    private lateinit var phoneEt:EditText
    private lateinit var dobEt:EditText

    private lateinit var save:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View= inflater.inflate(R.layout.fragment_basic_info, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        save.setOnClickListener{
            if(TextUtils.isEmpty(nameEt.text.toString())){
                Toast.makeText(context,"Name should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(gmailEt.text.toString())){
                Toast.makeText(context,"Gmail should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(phoneEt.text.toString())){
                Toast.makeText(context,"Phone No should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                var id=UUID.randomUUID().toString()
                var basicInfo=BasicInfo(id, nameEt.text.toString(), desigEt.text.toString(),addressEt.text.toString(),githubEt.text.toString(),linkedinEt.text.toString(),gmailEt.text.toString(),phoneEt.text.toString(),dobEt.text.toString())
                mBasicSalaryViewModel.addBasicInfo(basicInfo)
                Toast.makeText(context,"Successfully added",Toast.LENGTH_SHORT).show()
                var fragment= ObjectivesFragment.newInstance(id)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.add_new_resume_host, fragment).commit()


            }
        }
    }

    private fun findIds(v: View) {
        nameEt=v.findViewById(R.id.basic_info_name)
        desigEt=v.findViewById(R.id.basic_info_designation)
        addressEt=v.findViewById(R.id.basic_info_address)
        githubEt=v.findViewById(R.id.basic_info_github)
        linkedinEt=v.findViewById(R.id.basic_info_linkdin)
        gmailEt=v.findViewById(R.id.basic_info_gmail)
        phoneEt=v.findViewById(R.id.basic_info_phone)
        dobEt=v.findViewById(R.id.basic_info_dob)
        save=v.findViewById(R.id.save_and_next)
        mBasicSalaryViewModel=ViewModelProvider(this).get(BasicDataViewModel::class.java)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BasicInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BasicInfoFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}