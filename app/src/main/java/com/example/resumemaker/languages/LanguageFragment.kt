package com.example.resumemaker.languages

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
import com.example.resumemaker.hobbies.HobbyFragment
import com.example.resumemaker.referances.ReferanceFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [LanguageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LanguageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var languageViewModelForWriting: LanguageViewModelForWriting
    private lateinit var languageEt: EditText
    private lateinit var levelEt: EditText

    private lateinit var save: Button
    private lateinit var addMoree: Button

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
        var v:View= inflater.inflate(R.layout.fragment_language, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        save.setOnClickListener{

            if(TextUtils.isEmpty(languageEt.text.toString())){
                Toast.makeText(context,"Language title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if(TextUtils.isEmpty(levelEt.text.toString())){
                Toast.makeText(context,"Language level should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(param1!=null){
                    var language= Language(0,languageEt.text.toString(),levelEt.text.toString(),
                        param1!!
                    )
                    languageViewModelForWriting.addLanguage(language)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    var fragment= HobbyFragment.newInstance(param1!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.add_new_resume_host, fragment).commit()
                }

            }


        }

        addMoree.setOnClickListener{
            if(TextUtils.isEmpty(languageEt.text.toString())){
                Toast.makeText(context,"Language title should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if(TextUtils.isEmpty(levelEt.text.toString())){
                Toast.makeText(context,"Language level should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(param1!=null){
                    var language= Language(0,languageEt.text.toString(),levelEt.text.toString(),
                        param1!!
                    )
                    languageViewModelForWriting.addLanguage(language)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                   languageEt.setText("")
                    levelEt.setText("")
                }

            }
        }
    }

    private fun findIds(v: View) {
        languageEt =v.findViewById(R.id.lang_title)
        levelEt =v.findViewById(R.id.lang_level)
        save=v.findViewById(R.id.save_and_next_from_language)
        addMoree=v.findViewById(R.id.language_add_more)
        languageViewModelForWriting = ViewModelProvider(this).get(LanguageViewModelForWriting::class.java)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LanguageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            LanguageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}