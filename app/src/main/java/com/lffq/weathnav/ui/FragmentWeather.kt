package com.lffq.weathnav.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.lffq.weathnav.Constants
import com.lffq.weathnav.Constants.TAG
import com.lffq.weathnav.R
import com.lffq.weathnav.databinding.WeatherFragmentBinding
import com.lffq.weathnav.model.Current


class FragmentWeather : Fragment(R.layout.weather_fragment) {

    var viewmodel: WeatherViewModel? = null
    var currentData: Current? = null

    private lateinit var binding: WeatherFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel?.getByLocation()!!.observe(viewLifecycleOwner, { current ->
            currentData = current
            Log.d(TAG, "Current: ${current?.main?.temp}")
            Log.d(TAG, "Current data: ${currentData?.main?.temp}")
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