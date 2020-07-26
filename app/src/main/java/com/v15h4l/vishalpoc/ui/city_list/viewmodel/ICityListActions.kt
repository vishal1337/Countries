package com.v15h4l.vishalpoc.ui.city_list.viewmodel

import com.v15h4l.vishalpoc.model.City

/**
 * City List User Actions
 */
interface ICityListActions {

    /**
     * Open a new Screen to show Details
     * @param city
     */
    fun openCityDetails(city: City)

}