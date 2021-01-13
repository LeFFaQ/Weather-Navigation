package com.lffq.weathnav.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lffq.weathnav.model.Current
import com.lffq.weathnav.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {

    var current = MutableLiveData<Current>()

    @SuppressLint("CheckResult")
    fun getByLocation() {

        val repository = RepositoryProvider.provideSearchRepository()
        repository.latlon(55.354968, 86.087314)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                Log.d(TAG, "getByLocation: ${result.main?.temp}")
                current.value = result
            }, { error ->
                error.printStackTrace()
            })
    }


}