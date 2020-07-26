package com.v15h4l.vishalpoc.data.country.remote

import com.v15h4l.vishalpoc.model.CountryDto
import retrofit2.http.GET

/**
 * Service to Connect to remote Server
 */
interface CountryService {

    /**
     * Fetch a List of Country from Remote Server
     */
    @GET("/all")
    suspend fun getCountries(): List<CountryDto>

}