package com.example.resumemaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.profile.BasicInfo

class ProfileAdapter(var profileList: ArrayList<BasicInfo>, private val myInterfaceForView: MyInterfaceForView,private val myInterfaceForDelete: MyInterfaceForDelete,private val myInterfaceForEdit: MyInterfaceForEdit) : RecyclerView.Adapter<ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_for_profile_viewholder, parent, false)
        return ProfileViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bindItems(profileList[position])
        holder.buttonView.setOnClickListener {
            myInterfaceForView.onClick(profileList[position])
        }
        holder.buttonDelete.setOnClickListener{
            myInterfaceForDelete.onClick(profileList[position])
        }
        holder.buttonEdit.setOnClickListener {
            myInterfaceForEdit.onClick(profileList[position])
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}