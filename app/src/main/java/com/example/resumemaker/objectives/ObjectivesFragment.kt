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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.resumemaker.R
import com.example.resumemaker.experience.ExperienceFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private lateinit var mObjectiveViewModelForWriting: ObjectiveViewModelForWriting

private lateinit var dataEt:EditText
private lateinit var save: Button
private var objectiveData:String=""
/**
 * A simple [Fragment] subclass.
 * Use the [ObjectivesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObjectivesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

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
        var v:View= inflater.inflate(R.layout.fragment_objectives, container, false)
        findIds(v)
        factory()
        return v
    }
    private fun factory() {
        save.setOnClickListener{
            if(TextUtils.isEmpty(dataEt.text.toString())){
                objectiveData="empty"
            }
            else{
                objectiveData= dataEt.text.toString()
            }
                if(param1!=null){
                    var objective= Objective(0, objectiveData, param1!!)
                    mObjectiveViewModelForWriting.addObjective(objective)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    var fragment=ExperienceFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }




        }
    }

    private fun findIds(v: View) {
        dataEt=v.findViewById(R.id.objective_data)
        save=v.findViewById(R.id.save_and_next_from_objective)
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
        fun newInstance(param1: String) =
            ObjectivesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }
}