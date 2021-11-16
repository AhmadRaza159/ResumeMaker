package com.example.resumemaker.profile

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_info_table")
data class BasicInfo(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val name:String,
    val designation:String,
    val address:String,
    val github:String,
    val linkedin:String,
    val gmail:String,
    val phone:String,
    val dob:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(designation)
        parcel.writeString(address)
        parcel.writeString(github)
        parcel.writeString(linkedin)
        parcel.writeString(gmail)
        parcel.writeString(phone)
        parcel.writeString(dob)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BasicInfo> {
        override fun createFromParcel(parcel: Parcel): BasicInfo {
            return BasicInfo(parcel)
        }

        override fun newArray(size: Int): Array<BasicInfo?> {
            return arrayOfNulls(size)
        }
    }
}