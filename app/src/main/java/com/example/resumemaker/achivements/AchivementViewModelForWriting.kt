package com.example.resumemaker.achivements

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resumemaker.hobbies.Hobby
import com.example.resumemaker.profile.BasicInfoDatabase
import com.example.resumemaker.referances.Referance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchivementViewModelForWriting (application: Application): AndroidViewModel(application) {
    private val repository: AchivementRepository

    init {
        val achivementDao = BasicInfoDatabase.getDatabase(application).achivementDao()
        repository = AchivementRepository(achivementDao,"nill")
    }
    fun deleteData(obj: Achivement){
        repository.deleteData(obj)
    }
    fun addAchivement(achivement: Achivement){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAchivement(achivement)
        }
    }
    fun updateData(obj: Achivement){
        repository.updateData(obj)
    }

    fun getSpecificObj(id: String): LiveData<List<Achivement>>{
        return repository.readAllDat(id)
    }
}