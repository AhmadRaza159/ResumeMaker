package com.example.resumemaker.achivements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.R
import com.example.resumemaker.SectionViewholder
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceInterfaceEdit

class AchivementAdapter (var dataList: ArrayList<Achivement>, private val myInterfaceForEdit: AchivementInterface,private val myInterfaceForDelete: AchivementInterface): RecyclerView.Adapter<SectionViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_for_add_section, parent, false)
        return SectionViewholder(v)
    }

    override fun onBindViewHolder(holder: SectionViewholder, position: Int) {
        holder.bindItems(dataList.get(position).title,"")
        holder.buttonEdit.setOnClickListener {
            myInterfaceForEdit.onClick(dataList.get(position))
        }
        holder.buttonDelete.setOnClickListener {
            myInterfaceForDelete.onClick(dataList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}