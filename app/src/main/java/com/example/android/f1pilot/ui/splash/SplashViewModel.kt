package com.example.android.f1pilot.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {
   private val _isNavigation = MutableLiveData<Boolean>()
    val isNavigation : LiveData<Boolean> = _isNavigation

    init {
        waitForSplash()
    }

    private fun waitForSplash(){
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            _isNavigation.value = true
        }
    }
}