package com.v15h4l.vishalpoc.ui.country_list.viewmodel

/**
 * Country List User Actions
 */
interface ICountryListViewModel {

    /**
     * Fetch a List of countries
     * @param isOffline Load Data from Server
     */
    fun loadCountries(isOffline: Boolean = false)

}