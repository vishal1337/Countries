package com.v15h4l.vishalpoc.data.country.remote

import com.v15h4l.vishalpoc.BuildConfig
import com.v15h4l.vishalpoc.data.country.CountryDataSource
import com.v15h4l.vishalpoc.model.Country
import com.v15h4l.vishalpoc.model.toCountry
import javax.inject.Inject

class CountryRemoteDataSource @Inject constructor(
    private val countryService: CountryService
) : CountryDataSource {

    /*
        TODO: 26/07/20 Store all the Data in DB and Do this filtering in Repository
        Filter Early On to Reduce data processing Inside the App.
     */

    override suspend fun getCountries(): List<Country> =
        countryService.getCountries()
            .filter {
                it.region.equals(BuildConfig.REGION, true)
            }.map { it.toCountry() }
}