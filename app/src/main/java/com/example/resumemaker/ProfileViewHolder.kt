package com.example.resumemaker

import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.profile.BasicInfo

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var buttonView:ImageButton
    lateinit var buttonDelete:ImageButton
    lateinit var buttonEdit:ImageButton
    lateinit var profileTitle:TextView
    lateinit var profileTime:TextView
    lateinit var profileImage:ImageView
    fun bindItems(basicInfo: BasicInfo) {
        profileTitle = itemView.findViewById(R.id.profile_title) as TextView
        buttonView=itemView.findViewById(R.id.profile_view) as ImageButton
        buttonDelete=itemView.findViewById(R.id.profile_delete) as ImageButton
        buttonEdit=itemView.findViewById(R.id.profile_edit) as ImageButton
        profileTime=itemView.findViewById(R.id.profile_time) as TextView
        profileImage=itemView.findViewById(R.id.profile_image) as ImageView
        profileTitle.text = basicInfo.name
        profileTime.text=basicInfo.gmail
        profileImage.setImageBitmap(BitmapFactory.decodeFile(basicInfo.imgPath))
    }
}