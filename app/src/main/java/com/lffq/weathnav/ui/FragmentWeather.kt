package com.lffq.weathnav.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.lffq.weathnav.R

class FragmentWeather : Fragment(R.layout.weather_fragment) {

    val viewModel: WeatherViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}