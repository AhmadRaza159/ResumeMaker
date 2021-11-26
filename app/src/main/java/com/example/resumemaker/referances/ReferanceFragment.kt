package com.example.resumemaker.referances

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.MainActivity
import com.example.resumemaker.R
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.hobbies.HobbyAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [ReferanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReferanceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private lateinit var mReferanceViewModel: ReferanceViewModelForWriting
    private lateinit var companyNameEt: EditText
    private lateinit var personNameEt: EditText
    private lateinit var phoneEt: EditText
    private lateinit var gmailEt: EditText
    private lateinit var save: ImageButton
    private lateinit var addMore: ImageButton
    private var compName: String = ""
    private var persGmail: String = ""


    private lateinit var next: ImageButton
    private lateinit var newItemDialog: Dialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReferanceAdapter
    private var listData = ArrayList<Referance>()
    private var code: String = "add"
    private var idRef: Int = 0

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
        var v: View = inflater.inflate(R.layout.fragment_referance, container, false)
        findIds(v)
        factory()
        return v
    }

    private fun factory() {
        mReferanceViewModel.getSpecificObj(param1!!).observe(requireActivity(), Observer { obj ->
            if (listData.size != 0) {
                listData.clear()
            }
            for (i in obj) {
                listData.add(i)
            }
            adapter = ReferanceAdapter(listData, object : ReferanceInterface {
                override fun onClick(obj: Referance) {
                    idRef = obj.id
                    code = "edit"
                    personNameEt.setText(obj.personName)
                    gmailEt.setText(obj.gmail)
                    phoneEt.setText(obj.phone)
                    companyNameEt.setText(obj.companyName)
                    newItemDialog.show()
                }

            },object :ReferanceInterface{
                override fun onClick(obj: Referance) {
                    mReferanceViewModel.deleteReferance(obj)
                }

            })
            recyclerView.adapter = adapter
        })


        save.setOnClickListener {

            if (TextUtils.isEmpty(personNameEt.text.toString())) {
                Toast.makeText(context, "Person Name should not be empty", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(phoneEt.text.toString())) {
                Toast.makeText(context, "Phone No should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                if (TextUtils.isEmpty(companyNameEt.text.toString())) {
                    compName = "empty"
                } else {
                    compName = companyNameEt.text.toString()
                }
                if (TextUtils.isEmpty(gmailEt.text.toString())) {
                    persGmail = "empty"
                } else {
                    persGmail = gmailEt.text.toString()
                }
                if (code.equals("add")) {
                    var referance = Referance(
                        0,
                        compName,
                        personNameEt.text.toString(),
                        phoneEt.text.toString(),
                        persGmail,
                        param1!!
                    )
                    mReferanceViewModel.addReference(referance)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()


//                    var fragment= AchivementFragment.newInstance(param1!!)
//                    requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.add_new_resume_host, fragment).commit()
                } else {

                    var referance = Referance(
                        idRef,
                        compName,
                        personNameEt.text.toString(),
                        phoneEt.text.toString(),
                        persGmail,
                        param1!!
                    )
                    mReferanceViewModel.updateData(referance)

                    Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show()
                    newItemDialog.dismiss()


                }


            }


        }

        next.setOnClickListener {
            activity?.finish()
        }

        addMore.setOnClickListener {
            code="add"
            newItemDialog.show()

            /*
            if(TextUtils.isEmpty(personNameEt.text.toString())){
                Toast.makeText(context,"Person Name should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(phoneEt.text.toString())){
                Toast.makeText(context,"Phone No should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if (TextUtils.isEmpty(companyNameEt.text.toString())){
                    compName="empty"
                }
                else{
                    compName=companyNameEt.text.toString()
                }
                if (TextUtils.isEmpty(gmailEt.text.toString())){
                    persGmail="empty"
                }
                else{
                    persGmail=gmailEt.text.toString()
                }
                if(param1!=null){
                    var referance= Referance(0,compName,personNameEt.text.toString(),phoneEt.text.toString(),persGmail,
                        param1!!
                    )
                    mReferanceViewModel.addReference(referance)
                    Toast.makeText(context,"Successfully added", Toast.LENGTH_SHORT).show()
                    companyNameEt.setText("")
                    personNameEt.setText("")
                    phoneEt.setText("")
                    gmailEt.setText("")


                }



            }
*/
        }
    }


    private fun findIds(v: View) {
        recyclerView = v.findViewById(R.id.refereance_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        newItemDialog = Dialog(requireContext())
        newItemDialog.setContentView(R.layout.dialoge_referance_get_data)
        newItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        next = v.findViewById(R.id.referance_done)

        companyNameEt = newItemDialog.findViewById(R.id.referance_company)
        personNameEt = newItemDialog.findViewById(R.id.referance_person)
        phoneEt = newItemDialog.findViewById(R.id.referance_phone)
        gmailEt = newItemDialog.findViewById(R.id.referance_gmail)
        save = newItemDialog.findViewById(R.id.referance_save)
        addMore = v.findViewById(R.id.referance_add_more)
        mReferanceViewModel = ViewModelProvider(this).get(ReferanceViewModelForWriting::class.java)
    }


    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ReferanceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}