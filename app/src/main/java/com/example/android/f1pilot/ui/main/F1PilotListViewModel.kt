package com.example.android.f1pilot.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.f1pilot.data.db.Database
import com.example.android.f1pilot.data.db.FavF1PilotDao
import com.example.android.f1pilot.data.db.FavF1PilotEntity
import com.example.android.f1pilot.data.model.F1Pilot
import com.example.android.f1pilot.data.model.F1PilotList
import com.example.android.f1pilot.data.repository.F1PilotListRepo
import com.example.android.f1pilot.util.Result
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class F1PilotListViewModel @Inject constructor(@ApplicationContext private val context:Context, private val repository: F1PilotListRepo) :
    ViewModel() {
    private val _f1PilotList = MutableLiveData<Result<F1PilotList>>()
    val f1PilotList : LiveData<Result<F1PilotList>> = _f1PilotList
    private lateinit var f1PilotDao: FavF1PilotDao

    init {
        getBankList()
        initDatabase()
    }

    private fun initDatabase(){
        val db = Database.getDatabase(context)
        f1PilotDao = db!!.favDao()
    }

    private fun getBankList() {
        viewModelScope.launch {
            repository.getF1PilotList().collect {
                _f1PilotList.value = it
            }
        }
    }

    fun addOrRemoveFav(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
           F1Pilot(id).apply {
               this.isFav = this.isFav.not()
           }.run {
               f1PilotDao.setFav(this)
           }
        }
    }

}