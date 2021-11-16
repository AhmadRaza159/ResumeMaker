package com.example.resumemaker.educations

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "education_table")
data class Education (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val school:String,
    val degree:String,
    val startDate:String,
    val endDate:String,
    val details:String,
    val city:String,
    val foreignKey: String
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
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
        parcel.writeInt(id)
        parcel.writeString(school)
        parcel.writeString(degree)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(details)
        parcel.writeString(city)
        parcel.writeString(foreignKey)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Education> {
        override fun createFromParcel(parcel: Parcel): Education {
            return Education(parcel)
        }

        override fun newArray(size: Int): Array<Education?> {
            return arrayOfNulls(size)
        }
    }
}