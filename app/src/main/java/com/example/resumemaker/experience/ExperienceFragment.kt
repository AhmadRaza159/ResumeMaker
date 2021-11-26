package com.example.resumemaker.experience

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.DatePickerFragment
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
    private lateinit var save: ImageButton
    private lateinit var next: ImageButton
    private lateinit var addMore: ImageButton
    private lateinit var titleEt: EditText
    private lateinit var companyEt: EditText
    private lateinit var startDateEt: Button
    private lateinit var endDateEt: Button
    private lateinit var detailsEt: EditText
    private lateinit var cityEt: EditText
    private var companyDetails: String = ""
    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExperienceAdapter
    private var listData = ArrayList<Experience>()
    private var code: String = "add"
    private var startDateString: String = ""
    private var endDateString: String = ""
    private var idExp: Int = 0


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
        var v: View = inflater.inflate(R.layout.fragment_experience, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {

        experienceViewModelForWriting.getSpecificObj(param1!!)
            .observe(requireActivity(), Observer { obj ->
                if (listData.size != 0) {
                    listData.clear()
                }
                for (i in obj) {
                    listData.add(i)
                }
                adapter = ExperienceAdapter(listData, object : ExperienceInterfaceEdit {
                    override fun onClick(obj: Experience) {
                        code = "edit"
                        idExp = obj.id
                        newItemDialog.show()

                        Toast.makeText(requireContext(), "Reach here", Toast.LENGTH_SHORT).show()
                        titleEt.setText(obj.title)
                        companyEt.setText(obj.company)
                        startDateEt.setText(obj.startDate)
                        endDateEt.setText(obj.EndDate)
                        startDateEt.setTextColor(Color.BLACK)
                        endDateEt.setTextColor(Color.BLACK)
                        cityEt.setText(obj.city)
                        detailsEt.setText(obj.details)
                    }

                }, object :ExperienceInterfaceEdit{
                    override fun onClick(obj: Experience) {
                        experienceViewModelForWriting.deleteData(obj)
                    }

                })
                recyclerView.adapter = adapter

            })

        /////////////////////////
        startDateEt.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val dialog: DatePickerFragment = DatePickerFragment.newInstance()
            dialog.setTargetFragment(this, 3)
            dialog.show(
                fragmentManager,
                "dialog_sdate_exp"
            )
        }

        endDateEt.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val dialog: DatePickerFragment = DatePickerFragment.newInstance()
            dialog.setTargetFragment(this, 4)
            dialog.show(
                fragmentManager,
                "dialog_edate_exp"
            )
        }

        ///

        save.setOnClickListener {

            if (TextUtils.isEmpty(titleEt.text.toString())) {
                Toast.makeText(context, "Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(companyEt.text.toString())) {
                Toast.makeText(context, "Company Name should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(cityEt.text.toString())) {
                Toast.makeText(context, "City Name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(startDateEt.text.toString())) {
                Toast.makeText(context, "Start Date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(endDateEt.text.toString())) {
                Toast.makeText(context, "End Date should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                companyDetails = if (TextUtils.isEmpty(detailsEt.text.toString())) {
                    "empty"
                } else {
                    detailsEt.text.toString()
                }
                if (code == "add") {
                    val experience = Experience(
                        0,
                        titleEt.text.toString(),
                        companyEt.text.toString(),
                        cityEt.text.toString(),
                        startDateEt.text.toString(),
                        endDateEt.text.toString(),
                        companyDetails,
                        param1!!
                    )
                    experienceViewModelForWriting.addExperience(experience)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                } else {
                    val experience = Experience(
                        idExp,
                        titleEt.text.toString(),
                        companyEt.text.toString(),
                        cityEt.text.toString(),
                        startDateEt.text.toString(),
                        endDateEt.text.toString(),
                        companyDetails,
                        param1!!
                    )
                    experienceViewModelForWriting.updateData(experience)
                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                }
            }
        }
        next.setOnClickListener {
            var fragment = SkillsFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }
        addMore.setOnClickListener {
            code="add"

            titleEt.setText("")
            companyEt.setText("")
            startDateEt.setText("")
            endDateEt.setText("")

            cityEt.setText("")
            detailsEt.setText("")

            startDateString=""
            endDateString=""

            newItemDialog.show()
            /*if(TextUtils.isEmpty(titleEt.text.toString())){
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
                    titleEt.setText("")
                    companyEt.setText("")
                    cityEt.setText("")
                    startDateEt.setText("")
                    endDateEt.setText("")
                    detailsEt.setText("")
                }
            }*/
        }
    }

    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.experience_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addMore = v.findViewById(R.id.experience_add_more)
        next = v.findViewById(R.id.experience_done)
        experienceViewModelForWriting =
            ViewModelProvider(this).get(ExperienceViewModelForWriting::class.java)

        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_experience_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        titleEt = newItemDialog.findViewById(R.id.experience_title)
        companyEt = newItemDialog.findViewById(R.id.experience_company)
        cityEt = newItemDialog.findViewById(R.id.experience_city)
        startDateEt = newItemDialog.findViewById(R.id.experience_start_date)
        endDateEt = newItemDialog.findViewById(R.id.experience_end_date)
        detailsEt = newItemDialog.findViewById(R.id.experience_detail)
        save = newItemDialog.findViewById(R.id.save_and_next_from_experience)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {

            if(requestCode==3){
                startDateString = data!!.getStringExtra("date")!!
                val date2: Array<String> = startDateString.split(" ").toTypedArray()
                startDateString = date2[1]+ " " + date2[5]

                startDateEt.setText(startDateString)
                startDateEt.setTextColor(Color.BLACK)

            }
            if(requestCode==4){
                endDateString = data!!.getStringExtra("date")!!
                val date2: Array<String> = endDateString.split(" ").toTypedArray()
                endDateString = date2[1]+ " " + date2[5]

                endDateEt.setText(endDateString)
                endDateEt.setTextColor(Color.BLACK)

            }
        }
    }
}