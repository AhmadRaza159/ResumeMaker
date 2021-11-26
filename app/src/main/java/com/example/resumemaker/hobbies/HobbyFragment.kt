package com.example.resumemaker.hobbies

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
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceViewModelForWriting
import com.example.resumemaker.languages.Language
import com.example.resumemaker.languages.LanguageAdapter
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
    private lateinit var save: ImageButton
    private lateinit var addMore: ImageButton
    private lateinit var titleEt: EditText


    private lateinit var next: ImageButton
    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HobbyAdapter
    private var listData = ArrayList<Hobby>()
    private var code: String = "add"
    private var idHob: Int = 0


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
        var v: View = inflater.inflate(R.layout.fragment_hobby, container, false)
        findIds(v)
        factory()
        return v
    }


    private fun factory() {
        hobbyViewModel.getSpecificObj(param1!!).observe(requireActivity(), Observer { obj ->
            if (listData.size != 0) {
                listData.clear()
            }
            for (i in obj) {
                listData.add(i)
            }
            adapter = HobbyAdapter(listData, object : HobbyInterface {
                override fun onClick(obj: Hobby) {
                    idHob = obj.id
                    code = "edit"
                    titleEt.setText(obj.title)
                    newItemDialog.show()
                }

            }, object : HobbyInterface{
                override fun onClick(obj: Hobby) {
                    hobbyViewModel.deleteData(obj)
                }

            })
            recyclerView.adapter = adapter

        })


        save.setOnClickListener {

            if (TextUtils.isEmpty(titleEt.text.toString())) {
                Toast.makeText(context, "Title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {

                if (code.equals("add")) {
                    var hobby = Hobby(
                        0, titleEt.text.toString(),
                        param1!!
                    )
                    hobbyViewModel.addHobby(hobby)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                } else {

                    var hobby = Hobby(
                        idHob, titleEt.text.toString(),
                        param1!!
                    )
                    hobbyViewModel.updateData(hobby)

                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                }
            }
        }
        next.setOnClickListener {

            var fragment = ReferanceFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }

        addMore.setOnClickListener {
            code="add"
            newItemDialog.show()

            /*if(TextUtils.isEmpty(titleEt.text.toString())){
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
            }*/
        }
    }

    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.hobby_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_hobby_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        next = v.findViewById(R.id.hobby_done)
        addMore = v.findViewById(R.id.hobby_add_more)
        titleEt = newItemDialog.findViewById(R.id.hobby_title)
        save = newItemDialog.findViewById(R.id.hobby_save)
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