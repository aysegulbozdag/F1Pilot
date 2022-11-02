package com.example.android.f1pilot.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.f1pilot.data.model.F1PilotList
import com.example.android.f1pilot.data.repository.F1PilotListRepo
import com.example.android.f1pilot.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class F1PilotListViewModel @Inject constructor(private val repository: F1PilotListRepo) :
    ViewModel() {
    private val _f1PilotList = MutableLiveData<Result<F1PilotList>>()
    val f1PilotList : LiveData<Result<F1PilotList>> = _f1PilotList

    init {
        getBankList()
    }

    private fun getBankList() {
        viewModelScope.launch {
            repository.getF1PilotList().collect {
                _f1PilotList.value = it
            }
        }

    }

}