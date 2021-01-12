package com.lffq.weathnav.network

import com.lffq.weathnav.network.Repository

object RepositoryProvider {
        fun provideSearchRepository(): Repository {
            return Repository(WeatherApi.create())
    }
}