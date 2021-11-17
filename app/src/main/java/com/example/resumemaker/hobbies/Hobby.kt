package com.example.resumemaker.hobbies

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hobby_table")
data class Hobby (
    @PrimaryKey(autoGenerate = true)
                  val id:Int,
                  val title:String,
                  val foreignKey: String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(foreignKey)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hobby> {
        override fun createFromParcel(parcel: Parcel): Hobby {
            return Hobby(parcel)
        }

        override fun newArray(size: Int): Array<Hobby?> {
            return arrayOfNulls(size)
        }
    }
}