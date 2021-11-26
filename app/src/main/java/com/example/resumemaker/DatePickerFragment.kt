package com.example.resumemaker

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [DatePickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatePickerFragment : DialogFragment() {
    // TODO: Rename and change types of parameters




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        // Inflate the layout for this fragment
        val v = LayoutInflater.from(activity).inflate(R.layout.fragment_date_picker, null)
        var datePicker: DatePicker? = null
        datePicker = v.findViewById<View>(R.id.dialog_date_picker) as DatePicker
        return AlertDialog.Builder(activity)
            .setTitle("Pick date")
            .setView(v)
            .setPositiveButton(
                android.R.string.ok
            ) { dialog, which ->
                val date = GregorianCalendar(
                    datePicker.getYear(),
                    datePicker.getMonth(),
                    datePicker.getDayOfMonth()
                ).time
                val intent = Intent()
                intent.putExtra("date", date.toString())
                targetFragment!!.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }.create()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DatePickerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DatePickerFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}