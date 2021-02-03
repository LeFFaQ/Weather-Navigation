package com.lffq.weathnav.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.lffq.weathnav.model.Current
import com.lffq.weathnav.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MainActivityRepo {

    val getCurrent = MutableLiveData<Current>()
    @SuppressLint("CheckResult")
    fun getCurrentWeather(latitude: Double, longitude: Double): MutableLiveData<Current> {

        val repository = RepositoryProvider.provideSearchRepository()
        repository.latlon(latitude, longitude)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.d(ContentValues.TAG, "getByLocation: ${result.main?.temp}")
                    getCurrent.value = result

                }, { error ->
                    error.printStackTrace()
                })

        return getCurrent
    }
}