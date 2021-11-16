package com.example.resumemaker.achivements

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.referances.Referance

@Dao
interface AchivementDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAchivement(achivement: Achivement)
    @Query("SELECT * FROM achivement_table where foreignKey = :id")
    fun readAllData(id : String): LiveData<List<Achivement>>

    @Delete
    fun delete(model: Achivement)
}