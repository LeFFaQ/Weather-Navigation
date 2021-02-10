package com.lffq.weathnav.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.*

import com.lffq.weathnav.Constants.TAG
import com.lffq.weathnav.model.Current
import com.lffq.weathnav.repository.MainActivityRepo

class WeatherViewModel : ViewModel() {

    lateinit var current: MutableLiveData<Current>

    var temp: String? = null
    var tempMax: String? = null
    var tempMin: String? = null
    var city: String? = null


    @SuppressLint("CheckResult")
    fun getByLocation(): LiveData<Current> {
        current = MainActivityRepo.getCurrentWeather(55.354968, 86.087314)
        Log.d("123", "Viewmodel: ${current.value?.main?.temp}")
        return current
    }

    fun cityFormatter(country: String, city: String): String {
        val formatted = "$country, $city"

        return formatted
    }

}