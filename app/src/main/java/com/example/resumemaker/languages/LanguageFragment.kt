package com.example.resumemaker.languages

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
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.achivements.AchivementAdapter
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

    private lateinit var save: ImageButton
    private lateinit var addMoree: ImageButton

    private lateinit var poorLangButton: Button
    private lateinit var goodLangButton: Button
    private lateinit var excellentLangButton: Button

    private lateinit var next: ImageButton
    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LanguageAdapter
    private var listData = ArrayList<Language>()
    private var code: String = "add"
    private var langLevel: String = ""
    private var idLang: Int = 0

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
        var v: View = inflater.inflate(R.layout.fragment_language, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        languageViewModelForWriting.getSpecificObj(param1!!)
            .observe(requireActivity(), Observer { obj ->
                if (listData.size != 0) {
                    listData.clear()
                }
                for (i in obj) {
                    listData.add(i)
                }
                adapter = LanguageAdapter(listData, object : LanguageInterface {
                    override fun onClick(obj: Language) {
                        idLang = obj.id
                        code = "edit"
                        languageEt.setText(obj.lang)
                        if (obj.expLevel.equals("Poor")){
                            poorLangButton.setBackgroundColor(Color.BLUE)
                            goodLangButton.setBackgroundColor(Color.GRAY)
                            excellentLangButton.setBackgroundColor(Color.GRAY)
                            langLevel="Poor"
                        }
                        else if(obj.expLevel.equals("Good")){
                            poorLangButton.setBackgroundColor(Color.GRAY)
                            goodLangButton.setBackgroundColor(Color.BLUE)
                            excellentLangButton.setBackgroundColor(Color.GRAY)
                            langLevel="Good"
                        }
                        else if(obj.expLevel.equals("Excellent")){
                            poorLangButton.setBackgroundColor(Color.GRAY)
                            goodLangButton.setBackgroundColor(Color.GRAY)
                            excellentLangButton.setBackgroundColor(Color.BLUE)
                            langLevel="Excellent"
                        }

                        newItemDialog.show()
                    }


                }, object : LanguageInterface {
                    override fun onClick(obj: Language) {
                        languageViewModelForWriting.deleteData(obj)
                    }

                })
                recyclerView.adapter = adapter
            })

///////////////////////////////
        poorLangButton.setOnClickListener{
            poorLangButton.setBackgroundColor(Color.BLUE)
            goodLangButton.setBackgroundColor(Color.GRAY)
            excellentLangButton.setBackgroundColor(Color.GRAY)
            langLevel="Poor"
        }
        /////////////////
        goodLangButton.setOnClickListener{
            poorLangButton.setBackgroundColor(Color.GRAY)
            goodLangButton.setBackgroundColor(Color.BLUE)
            excellentLangButton.setBackgroundColor(Color.GRAY)
            langLevel="Good"
        }

        /////////////////////
        excellentLangButton.setOnClickListener{
            poorLangButton.setBackgroundColor(Color.GRAY)
            goodLangButton.setBackgroundColor(Color.GRAY)
            excellentLangButton.setBackgroundColor(Color.BLUE)
            langLevel="Excellent"
        }

        ////////////////////////////



        save.setOnClickListener {

            if (TextUtils.isEmpty(languageEt.text.toString())) {
                Toast.makeText(context, "Language title should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener

            }
            if (TextUtils.isEmpty(langLevel)) {
                Toast.makeText(context, "Language level should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                if (code.equals("add")) {
                    var language = Language(
                        0, languageEt.text.toString(), langLevel,
                        param1!!
                    )
                    languageViewModelForWriting.addLanguage(language)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()

                } else {

                    var language = Language(
                        idLang, languageEt.text.toString(),langLevel,
                        param1!!
                    )
                    languageViewModelForWriting.updateData(language)

                    newItemDialog.dismiss()
                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()
                }

            }


        }

        next.setOnClickListener {


            var fragment = HobbyFragment.newInstance(param1!!)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.add_new_resume_host, fragment).commit()
        }

        addMoree.setOnClickListener {
            code="add"
            poorLangButton.setBackgroundColor(Color.GRAY)
            goodLangButton.setBackgroundColor(Color.GRAY)
            excellentLangButton.setBackgroundColor(Color.GRAY)
            langLevel=""
            languageEt.setText("")
            newItemDialog.show()
            /*
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

            }*/
        }
    }

    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.language_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialog_language_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        languageEt = newItemDialog.findViewById(R.id.lang_title)
        poorLangButton = newItemDialog.findViewById(R.id.lang_poor)
        goodLangButton = newItemDialog.findViewById(R.id.lang_good)
        excellentLangButton = newItemDialog.findViewById(R.id.lang_excellent)
        save = newItemDialog.findViewById(R.id.language_save)
        addMoree = v.findViewById(R.id.language_add_more)
        next = v.findViewById(R.id.language_done)
        languageViewModelForWriting =
            ViewModelProvider(this).get(LanguageViewModelForWriting::class.java)
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