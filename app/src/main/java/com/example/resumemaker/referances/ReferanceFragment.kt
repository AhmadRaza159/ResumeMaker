package com.example.resumemaker.referances

import android.content.Intent
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
import com.example.resumemaker.MainActivity
import com.example.resumemaker.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [ReferanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReferanceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var mReferanceViewModel: ReferanceViewModelForWriting
    private lateinit var companyNameEt: EditText
    private lateinit var personNameEt: EditText
    private lateinit var phoneEt: EditText
    private lateinit var gmailEt: EditText
    private lateinit var save: Button
    private lateinit var addMore: Button
    private var compName:String=""
    private var persGmail:String=""

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
        var v:View= inflater.inflate(R.layout.fragment_referance, container, false)
        findIds(v)
        factory()
        return v
    }
    private fun factory() {
        save.setOnClickListener{

            if(TextUtils.isEmpty(personNameEt.text.toString())){
                Toast.makeText(context,"Person Name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(phoneEt.text.toString())){
                Toast.makeText(context,"Phone No should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if (TextUtils.isEmpty(companyNameEt.text.toString())){
                    compName="empty"
                }
                else{
                    compName=companyNameEt.text.toString()
                }
                if (TextUtils.isEmpty(gmailEt.text.toString())){
                    persGmail="empty"
                }
                else{
                    persGmail=gmailEt.text.toString()
                }
                if(param1!=null){
                    var referance= Referance(0,compName,personNameEt.text.toString(),phoneEt.text.toString(),persGmail,
                        param1!!
                    )
                    mReferanceViewModel.addReference(referance)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    val intent=Intent(context,MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()


//                    var fragment= AchivementFragment.newInstance(param1!!)
//                    requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.add_new_resume_host, fragment).commit()
                }



            }


        }

        addMore.setOnClickListener{
            if(TextUtils.isEmpty(personNameEt.text.toString())){
                Toast.makeText(context,"Person Name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(phoneEt.text.toString())){
                Toast.makeText(context,"Phone No should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if (TextUtils.isEmpty(companyNameEt.text.toString())){
                    compName="empty"
                }
                else{
                    compName=companyNameEt.text.toString()
                }
                if (TextUtils.isEmpty(gmailEt.text.toString())){
                    persGmail="empty"
                }
                else{
                    persGmail=gmailEt.text.toString()
                }
                if(param1!=null){
                    var referance= Referance(0,compName,personNameEt.text.toString(),phoneEt.text.toString(),persGmail,
                        param1!!
                    )
                    mReferanceViewModel.addReference(referance)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    companyNameEt.setText("")
                    personNameEt.setText("")
                    phoneEt.setText("")
                    gmailEt.setText("")


                }



            }

        }
    }









    private fun findIds(v: View) {
        companyNameEt =v.findViewById(R.id.referance_company)
        personNameEt =v.findViewById(R.id.referance_person)
        phoneEt =v.findViewById(R.id.referance_phone)
        gmailEt =v.findViewById(R.id.referance_gmail)
        save=v.findViewById(R.id.save_from_referance)
        addMore=v.findViewById(R.id.referance_add_more)
        mReferanceViewModel = ViewModelProvider(this).get(ReferanceViewModelForWriting::class.java)
    }



    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ReferanceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}