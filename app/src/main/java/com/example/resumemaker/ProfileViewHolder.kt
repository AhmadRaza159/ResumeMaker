package com.example.resumemaker

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.profile.BasicInfo

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var buttonView:Button
    lateinit var buttonDelete:Button
    lateinit var buttonEdit:Button
    fun bindItems(basicInfo: BasicInfo) {
        val profileTitle = itemView.findViewById(R.id.profile_title) as TextView
        buttonView=itemView.findViewById(R.id.profile_view) as Button
        buttonDelete=itemView.findViewById(R.id.profile_delete) as Button
        buttonEdit=itemView.findViewById(R.id.profile_edit) as Button
        profileTitle.text = basicInfo.name
    }
}