package com.lffq.weathnav.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.lffq.weathnav.R
import com.lffq.weathnav.databinding.WeatherFragmentBinding
import com.lffq.weathnav.model.Current

class FragmentWeather : Fragment(R.layout.weather_fragment) {

    val viewModel: WeatherViewModel by navGraphViewModels(R.id.nav_graph)
    private lateinit var binding: WeatherFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getByLocation()
        binding = WeatherFragmentBinding.bind(view)

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.current.observe(viewLifecycleOwner, {
            binding.centerTemp.text = getString(R.string.ui_temp, it.main?.temp?.toInt().toString())
        })
    }
}