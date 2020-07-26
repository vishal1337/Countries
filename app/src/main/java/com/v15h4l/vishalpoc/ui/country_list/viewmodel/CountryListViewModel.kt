package com.v15h4l.vishalpoc.ui.country_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.v15h4l.vishalpoc.domain.country.GetCountriesUseCase
import com.v15h4l.vishalpoc.model.Country
import com.v15h4l.vishalpoc.result.Event
import com.v15h4l.vishalpoc.result.data
import com.v15h4l.vishalpoc.ui.country_list.view.CountryListViewState
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model responsible for preparing and managing the data for Country List.
 *
 * @see ViewModel
 */
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel(), ICountryListViewModel, ICountryListActions {

    // View State
    private val _state = MutableLiveData<CountryListViewState>()
    val stateList: LiveData<CountryListViewState>
        get() = _state

    private val _swipeRefreshing = MutableLiveData<Boolean>()
    val swipeRefreshing: LiveData<Boolean> = _swipeRefreshing

    // Observable Data
    private val _countryList = MutableLiveData<List<Country>>()
    val countryList: MutableLiveData<List<Country>>
        get() = _countryList

    // Actions
    private val _openCountryDetailsEvent = MutableLiveData<Event<Country>>()
    val openCountryDetailsEvent: LiveData<Event<Country>> = _openCountryDetailsEvent


    fun onSwipeRefresh() {
        // Start Showing Refreshing
        _swipeRefreshing.value = true

        loadCountries()
    }

    override fun loadCountries(isOffline: Boolean) {

        // Fetch data and revert
        viewModelScope.launch {
            //Show Loading State in UI
            //_state.value = CountryListViewState.Loading
            _swipeRefreshing.value = true

            try {
                getCountriesUseCase(isOffline).data
                    ?.let {
                        _countryList.value = it.also {
                            // Set Screen State
                            _state.value = if (it.isNotEmpty())
                                CountryListViewState.Loaded
                            else
                                CountryListViewState.Empty
                        }
                    }

            } catch (e: Exception) {
                _state.value = CountryListViewState.Error
            }

            _swipeRefreshing.value = false
        }
    }

    override fun openCountryDetails(country: Country) {
        _openCountryDetailsEvent.value = Event(country)
    }

}
