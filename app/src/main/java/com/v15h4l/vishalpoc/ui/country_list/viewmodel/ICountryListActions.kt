package com.v15h4l.vishalpoc.ui.country_list.viewmodel

import com.v15h4l.vishalpoc.model.Country

/**
 * Country List User Actions
 */
interface ICountryListActions {

    /**
     * Open a new Screen to show Details
     * @param country
     */
    fun openCountryDetails(country: Country)

}