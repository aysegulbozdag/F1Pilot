package com.example.android.f1pilot.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.f1pilot.data.model.F1PilotDetail
import com.example.android.f1pilot.data.model.F1PilotList
import com.example.android.f1pilot.data.repository.F1PilotListRepo
import com.example.android.f1pilot.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class F1PilotDetailViewModel @Inject constructor(private val repository: F1PilotListRepo) :
    ViewModel() {
    private val _f1PilotList = MutableLiveData<Result<F1PilotDetail>>()
    val f1PilotList : LiveData<Result<F1PilotDetail>> = _f1PilotList

    init {
        getBankList(1)
    }

    private fun getBankList(id:Int) {
        viewModelScope.launch {
            repository.getF1PilotDetail(id).collect {
                _f1PilotList.value = it
            }
        }

    }

}