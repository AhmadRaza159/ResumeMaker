package com.example.resumemaker.objectives

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "objectives_table")
data class Objective (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val data:String,
    val foreignKey: String
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(data)
        parcel.writeString(foreignKey)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Objective> {
        override fun createFromParcel(parcel: Parcel): Objective {
            return Objective(parcel)
        }

        override fun newArray(size: Int): Array<Objective?> {
            return arrayOfNulls(size)
        }
    }
}