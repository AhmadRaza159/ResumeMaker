package com.example.resumemaker.educations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.R
import com.example.resumemaker.SectionViewholder
import com.example.resumemaker.experience.Experience
import com.example.resumemaker.experience.ExperienceInterfaceEdit

class EducationAdapter (var dataList: ArrayList<Education>, private val myInterfaceForEdit: EducationInterface, private val myInterfaceForDelete: EducationInterface): RecyclerView.Adapter<SectionViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_for_add_section, parent, false)
        return SectionViewholder(v)
    }

    override fun onBindViewHolder(holder: SectionViewholder, position: Int) {
        holder.bindItems(dataList.get(position).degree,dataList.get(position).school)
        holder.buttonEdit.setOnClickListener {
            myInterfaceForEdit.onclick(dataList.get(position))
        }
        holder.buttonDelete.setOnClickListener {
            myInterfaceForDelete.onclick(dataList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}