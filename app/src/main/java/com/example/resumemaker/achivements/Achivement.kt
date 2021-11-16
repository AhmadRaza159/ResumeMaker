package com.example.resumemaker.achivements

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achivement_table")
data class Achivement (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val details:String,
    val foreignKey: String
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(details)
        parcel.writeString(foreignKey)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Achivement> {
        override fun createFromParcel(parcel: Parcel): Achivement {
            return Achivement(parcel)
        }

        override fun newArray(size: Int): Array<Achivement?> {
            return arrayOfNulls(size)
        }
    }
}