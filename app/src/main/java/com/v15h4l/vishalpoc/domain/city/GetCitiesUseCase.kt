package com.v15h4l.vishalpoc.domain.city

import com.v15h4l.vishalpoc.common.di.config.qualifier.DefaultDispatcher
import com.v15h4l.vishalpoc.data.city.CityRepository
import com.v15h4l.vishalpoc.domain.SuspendUseCase
import com.v15h4l.vishalpoc.model.City
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Get a List of Cities
 */
open class GetCitiesUseCase @Inject constructor(
    private val cityRepository: CityRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : SuspendUseCase<Boolean, List<City>>(defaultDispatcher) {

    override suspend fun execute(parameters: Boolean): List<City> =
        cityRepository.getCities(parameters)
}