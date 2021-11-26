package com.example.resumemaker.educations

import android.app.Dialog
import android.content.Intent
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
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.DatePickerFragment
import com.example.resumemaker.R
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceAdapter
import com.example.resumemaker.projects.ProjectFragment
import com.example.resumemaker.skills.SkillsFragment
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [EducationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EducationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private lateinit var educationViewModelForWriting: EducationViewModelForWriting
    private lateinit var schoolEt: EditText
    private lateinit var degreeEt: EditText
    private lateinit var cityEt: EditText
    private lateinit var startDateEt: Button
    private lateinit var endDateEt: Button
    private lateinit var detailsEt: EditText
    private lateinit var save: ImageButton
    private lateinit var next: ImageButton
    private lateinit var addMore: ImageButton
    private var educationDetails: String = ""
    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EducationAdapter
    private var listData = ArrayList<Education>()
    private var code: String = "add"
    private var startDateEdu: String = ""
    private var endDateEdu: String = ""
    private var idEdu: Int = 0

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
        var v: View = inflater.inflate(R.layout.fragment_education, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        educationViewModelForWriting.getSpecificObj(param1!!)
            .observe(requireActivity(), androidx.lifecycle.Observer { obj ->
                if (listData.size != 0) {
                    listData.clear()
                }
                for (i in obj) {
                    listData.add(i)
                }
                adapter = EducationAdapter(listData, object : EducationInterface {
                    override fun onclick(obj: Education) {
                        code = "edit"
                        idEdu = obj.id
                        newItemDialog.show()
                        degreeEt.setText(obj.degree)
                        schoolEt.setText(obj.school)
                        cityEt.setText(obj.city)
                        detailsEt.setText(obj.details)
                        startDateEt.setText(obj.startDate)
                        endDateEt.setText(obj.endDate)
                        startDateEt.setTextColor(Color.BLACK)
                        endDateEt.setTextColor(Color.BLACK)

                    }

                },object : EducationInterface{
                    override fun onclick(obj: Education) {
                        educationViewModelForWriting.deleteData(obj)
                    }

                })
                recyclerView.adapter = adapter
            })



        startDateEt.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val dialog: DatePickerFragment = DatePickerFragment.newInstance()
            dialog.setTargetFragment(this, 5)
            dialog.show(
                fragmentManager,
                "dialog_sdate_edu"
            )
        }
        endDateEt.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val dialog: DatePickerFragment = DatePickerFragment.newInstance()
            dialog.setTargetFragment(this, 6)
            dialog.show(
                fragmentManager,
                "dialog_edate_edu"
            )
        }

        save.setOnClickListener {
            if (TextUtils.isEmpty(schoolEt.text.toString())) {
                Toast.makeText(context, "School Name should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(degreeEt.text.toString())) {
                Toast.makeText(context, "Degree title should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(cityEt.text.toString())) {
                Toast.makeText(context, "City name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(startDateEt.text.toString())) {
                Toast.makeText(context, "Start date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(endDateEt.text.toString())) {
                Toast.makeText(context, "End date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                if (TextUtils.isEmpty(detailsEt.text.toString())) {
                    educationDetails = "empty"
                } else {
                    educationDetails = detailsEt.text.toString()
                }
                if (code.equals("add")) {
                    var education = Education(
                        0,
                        schoolEt.text.toString(),
                        degreeEt.text.toString(),
                        startDateEt.text.toString(),
                        endDateEt.text.toString(),
                        educationDetails,
                        cityEt.text.toString(),
                        param1!!
                    )
                    educationViewModelForWriting.addEducation(education)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()


                } else {

                    var education = Education(
                        idEdu,
                        schoolEt.text.toString(),
                        degreeEt.text.toString(),
                        startDateEt.text.toString(),
                        endDateEt.text.toString(),
                        educationDetails,
                        cityEt.text.toString(),
                        param1!!
                    )
                    educationViewModelForWriting.updateData(education)

                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()

                }


            }
        }
        next.setOnClickListener {
            var fragment = ProjectFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }

        addMore.setOnClickListener {
            code="add"
            degreeEt.setText("")
            schoolEt.setText("")
            cityEt.setText("")
            detailsEt.setText("")
            startDateEt.setText("")
            endDateEt.setText("")
            startDateEdu=""
            endDateEdu=""

            newItemDialog.show()
/*
            if (TextUtils.isEmpty(schoolEt.text.toString())) {
                Toast.makeText(context, "School Name should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(degreeEt.text.toString())) {
                Toast.makeText(context, "Degree title should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(cityEt.text.toString())) {
                Toast.makeText(context, "City name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(startDateEt.text.toString())) {
                Toast.makeText(context, "Start date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(endDateEt.text.toString())) {
                Toast.makeText(context, "End date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                if (TextUtils.isEmpty(detailsEt.text.toString())) {
                    educationDetails = "empty"
                } else {
                    educationDetails = detailsEt.text.toString()
                }
                if (param1 != null) {
                    var education = Education(
                        0,
                        schoolEt.text.toString(),
                        degreeEt.text.toString(),
                        startDateEt.text.toString(),
                        endDateEt.text.toString(),
                        educationDetails,
                        cityEt.text.toString(),
                        param1!!
                    )
                    educationViewModelForWriting.addEducation(education)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                   schoolEt.setText("")
                    degreeEt.setText("")
                    cityEt.setText("")
                    startDateEt.setText("")
                    endDateEt.setText("")
                    detailsEt.setText("")


                }


            }
*/
        }
    }

    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.education_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_education_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        schoolEt = newItemDialog.findViewById(R.id.education_school)
        degreeEt = newItemDialog.findViewById(R.id.education_degree)
        cityEt = newItemDialog.findViewById(R.id.education_city)
        startDateEt = newItemDialog.findViewById(R.id.education_start_date)
        endDateEt = newItemDialog.findViewById(R.id.education_end_date)
        detailsEt = newItemDialog.findViewById(R.id.education_details)
        save = newItemDialog.findViewById(R.id.education_save)
        addMore = v.findViewById(R.id.education_add_more)
        next = v.findViewById(R.id.education_done)
        educationViewModelForWriting =
            ViewModelProvider(this).get(EducationViewModelForWriting::class.java)

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EducationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            EducationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {

            if(requestCode==5){
                startDateEdu = data!!.getStringExtra("date")!!
                val date2: Array<String> = startDateEdu.split(" ").toTypedArray()
                startDateEdu = date2[1]+ " " + date2[5]

                startDateEt.setText(startDateEdu)
                startDateEt.setTextColor(Color.BLACK)

            }
            if(requestCode==6){
                endDateEdu = data!!.getStringExtra("date")!!
                val date2: Array<String> = endDateEdu.split(" ").toTypedArray()
                endDateEdu = date2[1]+ " " + date2[5]

                endDateEt.setText(endDateEdu)
                endDateEt.setTextColor(Color.BLACK)

            }
        }
    }
}