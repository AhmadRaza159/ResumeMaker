package com.example.resumemaker.profile

import RealPath
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.resumemaker.DatePickerFragment
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
    private lateinit var dobEt:Button
    private lateinit var imagePf:ImageView
    private var param1: String? = null
    private var param2: BasicInfo? = null

    private lateinit var save:ImageButton
    private var path:String=""
    private var dobString:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getParcelable(ARG_PARAM2)

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
        if (param1.equals("edit")){
            nameEt.setText(param2!!.name)
            desigEt.setText(param2!!.designation)
            addressEt.setText(param2!!.address)
            gmailEt.setText(param2!!.gmail)
            phoneEt.setText(param2!!.phone)
            githubEt.setText(param2!!.github)
            linkedinEt.setText(param2!!.linkedin)
            dobEt.setText(param2!!.dob)
            dobEt.setTextColor(Color.BLACK)
            path=param2!!.imgPath
            imagePf.setImageBitmap(BitmapFactory.decodeFile(path))
        }

        imagePf.setOnClickListener{
            val gallery: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 1)
        }

        dobEt.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val dialog: DatePickerFragment = DatePickerFragment.newInstance()
            dialog.setTargetFragment(this, 2)
            dialog.show(
                fragmentManager,
                "dialog_date"
            )
        }


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
                if(path.equals("")){
                    path="empty"
                }

                if (param1.equals("add")){
                    var id=UUID.randomUUID().toString()
                    var basicInfo=BasicInfo(id, nameEt.text.toString(), desigEt.text.toString(),addressEt.text.toString(),githubEt.text.toString(),linkedinEt.text.toString(),gmailEt.text.toString(),phoneEt.text.toString(),dobEt.text.toString(),path)
                    mBasicSalaryViewModel.addBasicInfo(basicInfo)
                    Toast.makeText(context,"Successfully added",Toast.LENGTH_SHORT).show()
                    var fragment= ObjectivesFragment.newInstance(id,"add")
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }
                else{
                    var basicInfo=BasicInfo(param2!!.id, nameEt.text.toString(), desigEt.text.toString(),addressEt.text.toString(),githubEt.text.toString(),linkedinEt.text.toString(),gmailEt.text.toString(),phoneEt.text.toString(),dobEt.text.toString(),path)
                    mBasicSalaryViewModel.updateData(basicInfo)
                    Toast.makeText(context,"Successfully updated",Toast.LENGTH_SHORT).show()
                    var fragment= ObjectivesFragment.newInstance(param2!!.id,"edit")
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }




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
        save=v.findViewById(R.id.basic_info_toolbar_done)
        imagePf=v.findViewById(R.id.basic_info_image)
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
        fun newInstance(param1: String, param2:BasicInfo) =
            BasicInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putParcelable(ARG_PARAM2,param2)

                }
            }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {
            if(requestCode==1){
                println("spot ${data?.data}")
                var rObj=RealPath
                path=rObj.getRealPath(requireContext(),data?.data!!)!!
                //println("ttt "+rr.getRealPath(applicationContext,data?.data!!))
                imagePf.setImageURI(data?.data)
            }
            if(requestCode==2){
                dobString = data!!.getStringExtra("date")!!
                val date2: Array<String> = dobString.split(" ").toTypedArray()
                dobString = date2[2] + " " +
                    date2[1]+ " " + date2[5]

                dobEt.setText(dobString)
                dobEt.setTextColor(Color.BLACK)

            }
        }
    }
}