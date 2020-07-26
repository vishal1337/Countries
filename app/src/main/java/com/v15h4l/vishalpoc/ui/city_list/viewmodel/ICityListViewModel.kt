package com.v15h4l.vishalpoc.ui.city_list.viewmodel

/**
 * City List User Actions
 */
interface ICityListViewModel {

    /**
     * Fetch a List of cities
     * @param forceReload Load Data from Server
     */
    fun loadCities(forceReload: Boolean = false)

}