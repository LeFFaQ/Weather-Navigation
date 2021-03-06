package com.lffq.weathnav.ui

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.*

import com.lffq.weathnav.model.Current
import com.lffq.weathnav.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {


    var currentData = MutableLiveData<Current>()

    fun cityFormatter(country: String, city: String): String {
        val formatted = "$country, $city"

        return formatted
    }

    @SuppressLint("CheckResult")
    fun getCurrentWeather(latitude: Double, longitude: Double): MutableLiveData<Current> {

        val repository = RepositoryProvider.provideSearchRepository()
        repository.latlon(latitude, longitude)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.d(ContentValues.TAG, "getByLocation: ${result.main?.temp}")
                    currentData.value = result

                }, { error ->
                    error.printStackTrace()
                })

        return currentData
    }
}