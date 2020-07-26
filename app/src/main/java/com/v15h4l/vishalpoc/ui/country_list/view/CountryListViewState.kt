package com.v15h4l.vishalpoc.ui.country_list.view

import com.v15h4l.vishalpoc.common.base.BaseViewState


/**
 * Different states for [CountryListFragment].
 *
 * @see BaseViewState
 */
sealed class CountryListViewState : BaseViewState {

    /**
     * Loaded country list.
     */
    object Loaded : CountryListViewState()

    /**
     * Loading country list.
     */
    object Loading : CountryListViewState()

    /**
     * Internet Not Available
     */
    object Offline : CountryListViewState()

    /**
     * Empty country list.
     */
    object Empty : CountryListViewState()

    /**
     * Error on loading country list.
     */
    object Error : CountryListViewState()


    // ============================================================================================
    //  Public helpers methods
    // ============================================================================================


    /**
     * Check if current view state is [Loaded].
     *
     * @return True if is loaded state, otherwise false.
     */
    fun isLoaded() = this is Loaded

    /**
     * Check if current view state is [Loading].
     *
     * @return True if is loading state, otherwise false.
     */
    fun isLoading() = this is Loading

    /**
     * Check if device is [Offline].
     *
     * @return True if device is Offline, otherwise false.
     */
    fun isOffline() = this is Offline

    /**
     * Check if current view state is [Empty].
     *
     * @return True if is empty state, otherwise false.
     */
    fun isEmpty() = this is Empty

    /**
     * Check if current view state is [Error].
     *
     * @return True if is error state, otherwise false.
     */
    fun isError() = this is Error

}
