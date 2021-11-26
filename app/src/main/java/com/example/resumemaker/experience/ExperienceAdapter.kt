package com.example.resumemaker.experience
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.MyInterfaceForEdit
import com.example.resumemaker.MyInterfaceForView
import com.example.resumemaker.R
import com.example.resumemaker.SectionViewholder

class ExperienceAdapter(var dataList: ArrayList<Experience>, private val myInterfaceForEdit: ExperienceInterfaceEdit, private val myInterfaceForDelete: ExperienceInterfaceEdit): RecyclerView.Adapter<SectionViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_for_add_section, parent, false)
        return SectionViewholder(v)
    }

    override fun onBindViewHolder(holder: SectionViewholder, position: Int) {
        holder.bindItems(dataList.get(position).title,dataList.get(position).company)
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