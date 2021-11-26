package com.example.resumemaker.hobbies

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.resumemaker.achivements.Achivement
import com.example.resumemaker.experience.Experience
@Dao
interface HobbyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addHobby(hobby: Hobby)

    @Query("SELECT * FROM hobby_table where foreignKey = :id")
    fun readAllData(id:String): LiveData<List<Hobby>>

    @Delete
    fun delete(model: Hobby)

    @Update
    fun updateData(model: Hobby)
}