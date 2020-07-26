package com.v15h4l.vishalpoc.data.city

import com.v15h4l.vishalpoc.BuildConfig
import com.v15h4l.vishalpoc.model.City
import javax.inject.Inject

/**
 * Repository to Fetch City data
 */
interface CityRepository {
    suspend fun getCities(forceReload: Boolean): List<City>
}


class CityRepositoryImpl @Inject constructor(
    private val cityService: CityService
) : CityRepository {

    override suspend fun getCities(forceReload: Boolean): List<City> =
        cityService.getCities()
            .filter {
                // Filter Early On to Reduce data processing Inside the App.
                it.region.equals(BuildConfig.REGION, true)
            }

}