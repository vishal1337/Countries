package com.v15h4l.vishalpoc.data.city

import com.v15h4l.vishalpoc.model.City
import retrofit2.http.GET

/**
 * Service to Connect to remote Server
 */
interface CityService {

    /**
     * Fetch a List of City from Remote Server
     */
    @GET("/all")
    suspend fun getCities(): List<City>

}