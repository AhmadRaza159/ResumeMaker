package com.example.resumemaker.projects

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
import com.example.resumemaker.achivements.AchivementFragment
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ProjectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProjectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private lateinit var mProjectViewModel: ProjectViewModelForWriting
    private lateinit var titleEt: EditText
    private lateinit var detailsEt: EditText

    private lateinit var save: ImageButton
    private lateinit var addMore: ImageButton
    private lateinit var next: ImageButton

    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProjectAdapter
    private var listData = ArrayList<Project>()
    private var code: String = "add"
    private var idPro: Int = 0

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
        var v: View = inflater.inflate(R.layout.fragment_project, container, false)
        findIds(v)
        factory()
        return v
    }


    private fun factory() {
        mProjectViewModel.getSpecificObj(param1!!).observe(requireActivity(), Observer { obj ->
            if (listData.size != 0) {
                listData.clear()
            }
            for (i in obj) {
                listData.add(i)
            }
            adapter = ProjectAdapter(listData, object : ProjectInterface {
                override fun onClick(obj: Project) {
                    idPro = obj.id
                    code = "edit"
                    titleEt.setText(obj.title)
                    detailsEt.setText(obj.details)
                    newItemDialog.show()
                }

            }, object : ProjectInterface {
                override fun onClick(obj: Project) {
                    mProjectViewModel.deleteData(obj)
                }
            })
            recyclerView.adapter = adapter
        })





        save.setOnClickListener {

            if (TextUtils.isEmpty(titleEt.text.toString())) {
                Toast.makeText(context, "Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(detailsEt.text.toString())) {
                Toast.makeText(context, "Project Details should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                if (code.equals("add")) {
                    var project = Project(
                        0, titleEt.text.toString(), detailsEt.text.toString(),
                        param1!!
                    )
                    mProjectViewModel.addProject(project)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                } else {

                    var project = Project(
                        idPro, titleEt.text.toString(), detailsEt.text.toString(),
                        param1!!
                    )
                    mProjectViewModel.updateData(project)

                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                }

            }


        }
        next.setOnClickListener {
            var fragment = AchivementFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }

        addMore.setOnClickListener {
            code="add"
            newItemDialog.show()
            /*
            if(TextUtils.isEmpty(titleEt.text.toString())){
                Toast.makeText(context,"Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(detailsEt.text.toString())){
                Toast.makeText(context,"Project Details should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(param1!=null){
                    var project= Project(0,titleEt.text.toString(),detailsEt.text.toString(),
                        param1!!
                    )
                    mProjectViewModel.addProject(project)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    titleEt.setText("")
                    detailsEt.setText("")

                }

            }
*/
        }
    }

    private fun findIds(v: View) {
        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_project_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        recyclerView = v.findViewById(R.id.project_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        titleEt = newItemDialog.findViewById(R.id.project_title)
        detailsEt = newItemDialog.findViewById(R.id.project_details)
        addMore = v.findViewById(R.id.project_add_more)
        next = v.findViewById(R.id.project_done)
        save = newItemDialog.findViewById(R.id.project_save)
        mProjectViewModel = ViewModelProvider(this).get(ProjectViewModelForWriting::class.java)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProjectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ProjectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}