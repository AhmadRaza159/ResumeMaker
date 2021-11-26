package com.example.resumemaker.referances

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.achivements.Achivement

@Dao
interface ReferanceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addReferance(referance: Referance)
    @Query("SELECT * FROM referance_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Referance>>

    @Delete
    fun delete(model: Referance)

    @Update
    fun updateData(model: Referance)

}