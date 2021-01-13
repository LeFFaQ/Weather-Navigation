package com.lffq.weathnav.network

import com.lffq.weathnav.model.Current
import io.reactivex.Observable

class Repository(val weatherApi: WeatherApi) {

    //Get city by latlon
    fun latlon(latitude: Double, longitude: Double): Observable<Current> {
        return weatherApi.byLatLon(latitude, longitude)
    }

}