package com.lffq.weathnav.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.lffq.weathnav.R

class  WeatherForecastAdapter(var context: Context?): RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastAdapter.MyViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.forecast_item, parent, false) as LinearLayout
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherForecastAdapter.MyViewHolder, position: Int) {
        //val imageView = holder.imageTitle

    }
    override fun getItemCount(): Int {
        //Метод, возвращающий кол-во полученных элементов (новостей)
        return 5
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //Элементы интерфейса


        //init { itemView.setOnClickListener(this) }

    }
}
