package com.v15h4l.vishalpoc.data.country

import com.v15h4l.vishalpoc.data.country.local.CountryLocalDataSource
import com.v15h4l.vishalpoc.data.country.remote.CountryRemoteDataSource
import com.v15h4l.vishalpoc.model.Country
import javax.inject.Inject

/**
 * Repository to Fetch Country data
 */
class CountryRepository @Inject constructor(
    private val countryLocalDataSource: CountryLocalDataSource,
    private val countryRemoteDataSource: CountryRemoteDataSource
) : CountryDataSource {

    /**
     * Choose Data source based on Network Connectivity
     */
    suspend fun getCountries(isOffline: Boolean): List<Country> = if (isOffline) {
        countryLocalDataSource.getCountries()
    } else getCountries()

    /**
     * Make Remote API call and Return the Data, also Persist It for Offline Use.
     */
    override suspend fun getCountries(): List<Country> =
        countryRemoteDataSource.getCountries()
            .also { countryLocalDataSource.insertCountries(it) }

}