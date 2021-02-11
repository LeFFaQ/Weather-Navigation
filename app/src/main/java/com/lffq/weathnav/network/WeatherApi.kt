package com.lffq.weathnav.network

import com.lffq.weathnav.Constants
import com.lffq.weathnav.model.Current
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //Current Weather
    @GET("/data/2.5/weather")
    fun byCityName(
            @Query("q") City: String,
            @Query("appid") ApiKey: String = Constants.appid,
            @Query("units") metrics: String = Constants.metric
    ): Observable<Current>

    //Current Weather
    @GET("/data/2.5/weather")
    fun byLatLon(
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("appid") apiKey: String = Constants.appid,
            @Query("units") metrics: String = Constants.metric
            ): Observable<Current>

    companion object Factory {
        fun create(): WeatherApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/")
                .build()

            return retrofit.create(WeatherApi::class.java);
        }
    }
}