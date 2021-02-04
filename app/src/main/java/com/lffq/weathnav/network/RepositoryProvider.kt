package com.lffq.weathnav.network

object RepositoryProvider {
        fun provideSearchRepository(): Repository {
            return Repository(WeatherApi.create())
    }
}