package com.example.resumemaker

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.profile.BasicInfo

class SectionViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var titleTv: TextView
    lateinit var dataTv: TextView
    lateinit var buttonDelete: ImageButton
    lateinit var buttonEdit: ImageButton
    fun bindItems(title: String, data:String) {
        buttonDelete=itemView.findViewById(R.id.section_delete_button) as ImageButton
        buttonEdit=itemView.findViewById(R.id.section_edit_button) as ImageButton
        titleTv=itemView.findViewById(R.id.section_title) as TextView
        dataTv=itemView.findViewById(R.id.section_data) as TextView

        titleTv.setText(title)
        dataTv.setText(data)


    }
}