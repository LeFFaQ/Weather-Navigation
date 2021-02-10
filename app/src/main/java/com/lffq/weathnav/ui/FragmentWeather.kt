package com.lffq.weathnav.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.lffq.weathnav.Constants.TAG
import com.lffq.weathnav.R
import com.lffq.weathnav.databinding.WeatherFragmentBinding
import com.lffq.weathnav.model.Current

class FragmentWeather : Fragment(R.layout.weather_fragment) {

    var viewmodel: WeatherViewModel? = null
    private lateinit var binding: WeatherFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel?.getByLocation()!!.observe(viewLifecycleOwner, { current ->

            Log.d(TAG, "Current, Fragment: ${current.main?.temp}")
            Log.d(TAG, "Current, Fragment: ${current.main?.feelsLike}")
            Log.d(TAG, "Current, Fragment: ${current.name}")

            viewmodel?.cityFormatter(current.sys?.country.toString(), current.name.toString())
            viewmodel?.apply {
                temp = current.main?.temp.toString()
                tempMax = current.main?.tempMax?.toInt().toString()
                tempMin = current.main?.tempMin?.toInt().toString()
            }
            Log.d(TAG, "onViewCreated: ${viewmodel?.temp}")
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewmodel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}