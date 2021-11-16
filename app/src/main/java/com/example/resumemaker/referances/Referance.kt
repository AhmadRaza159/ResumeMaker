package com.example.resumemaker.referances

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "referance_table")
data class Referance(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val companyName:String,
    val personName:String,
    val phone:String,
    val gmail:String,
    val foreignKey: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(companyName)
        parcel.writeString(personName)
        parcel.writeString(phone)
        parcel.writeString(gmail)
        parcel.writeString(foreignKey)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Referance> {
        override fun createFromParcel(parcel: Parcel): Referance {
            return Referance(parcel)
        }

        override fun newArray(size: Int): Array<Referance?> {
            return arrayOfNulls(size)
        }
    }
}