package com.v15h4l.vishalpoc.data.country

import com.v15h4l.vishalpoc.model.Country

/**
 * Main entry point for accessing Country data.
 */
interface CountryDataSource {

    suspend fun getCountries(): List<Country>

}