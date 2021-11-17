package com.example.resumemaker.educations

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
import com.example.resumemaker.projects.ProjectFragment
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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
    private lateinit var startDateEt: EditText
    private lateinit var endDateEt: EditText
    private lateinit var detailsEt: EditText
    private lateinit var save: Button
    private lateinit var addMore: Button
    private var educationDetails: String = ""


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
                    var fragment = ProjectFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()

                }


            }
        }

        addMore.setOnClickListener {

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

        }
    }

    private fun findIds(v: View) {
        schoolEt = v.findViewById(R.id.education_school)
        degreeEt = v.findViewById(R.id.education_degree)
        cityEt = v.findViewById(R.id.education_city)
        startDateEt = v.findViewById(R.id.education_start_date)
        endDateEt = v.findViewById(R.id.education_end_date)
        detailsEt = v.findViewById(R.id.education_details)
        save = v.findViewById(R.id.save_and_next_from_education)
        addMore = v.findViewById(R.id.education_add_more)
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
}