package com.example.resumemaker.objectives

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//import com.example.resumemaker.MainActivity
import com.example.resumemaker.R
import com.example.resumemaker.experience.ExperienceFragment
import android.app.Activity
import android.content.Context
import android.widget.ImageButton
import com.example.resumemaker.AddResumeActivity

import com.example.resumemaker.MainActivity




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var mObjectiveViewModelForWriting: ObjectiveViewModelForWriting

private lateinit var dataEt:EditText
private lateinit var save: ImageButton
private var objectiveData:String=""
/**
 * A simple [Fragment] subclass.
 * Use the [ObjectivesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObjectivesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var activity: AddResumeActivity? = null


    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.activity=activity as AddResumeActivity
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v:View= inflater.inflate(R.layout.fragment_objectives, container, false)
        findIds(v)
        factory()
        return v
    }
    private fun factory() {
        if (param2.equals("edit")){
            mObjectiveViewModelForWriting.getSpecificObj(param1!!).observe(requireActivity(),
                Observer { obj->
                    dataEt.setText(obj.get(0).data)
                })
        }

        save.setOnClickListener{
            if(TextUtils.isEmpty(dataEt.text.toString())){
                objectiveData="empty"
            }
            else{
                objectiveData= dataEt.text.toString()
            }
                if(param2.equals("add")){
                    var objective= Objective(0, objectiveData, param1!!)
                    mObjectiveViewModelForWriting.addObjective(objective)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()

                }
            else{
                    mObjectiveViewModelForWriting.getSpecificObj(param1!!).observe(requireActivity(), Observer { obj->
                        var objective= Objective(obj.get(0).id, objectiveData, param1!!)
                        mObjectiveViewModelForWriting.updateData(objective)

                    })
                    Toast.makeText(context,"Successfully updated", Toast.LENGTH_SHORT).show()


                }
            var fragment=ExperienceFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()




        }
    }

    private fun findIds(v: View) {
        dataEt=v.findViewById(R.id.objective_data)
        save=v.findViewById(R.id.objective_toolbar_done)
       /* mObjectiveViewModel = ViewModelProviders.of(
            this,
            viewModelFactory { ObjectiveViewModel(requireActivity().application,param1!!) }
        ).get(ObjectiveViewModel::class.java)*/
        mObjectiveViewModelForWriting=ViewModelProvider(this).get(ObjectiveViewModelForWriting::class.java)



    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ObjectivesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ObjectivesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }
}