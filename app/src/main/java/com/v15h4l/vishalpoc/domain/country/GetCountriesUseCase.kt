package com.v15h4l.vishalpoc.domain.country

import com.v15h4l.vishalpoc.common.di.config.qualifier.DefaultDispatcher
import com.v15h4l.vishalpoc.data.country.CountryRepository
import com.v15h4l.vishalpoc.domain.SuspendUseCase
import com.v15h4l.vishalpoc.model.Country
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Get a List of Countries
 */
open class GetCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : SuspendUseCase<Boolean, List<Country>>(defaultDispatcher) {

    override suspend fun execute(parameters: Boolean): List<Country> =
        countryRepository.getCountries(parameters)

}