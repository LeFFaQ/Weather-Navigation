package com.lffq.weathnav.ui

import android.annotation.SuppressLint
import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lffq.weathnav.model.Current
import com.lffq.weathnav.repository.MainActivityRepo

class WeatherViewModel : ViewModel() {

    var current: MutableLiveData<Current>? = null

    @SuppressLint("CheckResult")
    fun getByLocation(): LiveData<Current>? {
        current = MainActivityRepo.getCurrentWeather(55.354968, 86.087314)
        Log.d("123", "Viewmodel: ${current!!.value?.main?.temp}")
        return current
    }


}