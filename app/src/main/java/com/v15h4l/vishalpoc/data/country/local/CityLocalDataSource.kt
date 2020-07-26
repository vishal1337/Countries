package com.v15h4l.vishalpoc.data.country.local

import com.v15h4l.vishalpoc.data.country.CountryDataSource
import com.v15h4l.vishalpoc.model.Country
import javax.inject.Inject

class CountryLocalDataSource @Inject constructor(
    private val countryDao: CountryDao
) : CountryDataSource {

    override suspend fun getCountries(): List<Country> =
        countryDao.getCountries()

    suspend fun insertCountries(countries: List<Country>) {
        countryDao.insertAll(countries)
    }

}