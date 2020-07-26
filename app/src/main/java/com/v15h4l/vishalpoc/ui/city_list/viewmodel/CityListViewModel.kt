package com.v15h4l.vishalpoc.ui.city_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.v15h4l.vishalpoc.domain.city.GetCitiesUseCase
import com.v15h4l.vishalpoc.model.City
import com.v15h4l.vishalpoc.result.Event
import com.v15h4l.vishalpoc.result.data
import com.v15h4l.vishalpoc.ui.city_list.view.CityListViewState
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model responsible for preparing and managing the data for City List.
 *
 * @see ViewModel
 */
class CityListViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase
) : ViewModel(), ICityListViewModel, ICityListActions {

    // View State
    private val _state = MutableLiveData<CityListViewState>()
    val stateList: LiveData<CityListViewState>
        get() = _state

    private val _swipeRefreshing = MutableLiveData<Boolean>()
    val swipeRefreshing: LiveData<Boolean> = _swipeRefreshing

    // Observable Data
    private val _cityList = MutableLiveData<List<City>>()
    val cityList: MutableLiveData<List<City>>
        get() = _cityList

    // Actions
    private val _openCityDetailsEvent = MutableLiveData<Event<City>>()
    val openCityDetailsEvent: LiveData<Event<City>> = _openCityDetailsEvent


    fun onSwipeRefresh() {
        // Start Showing Refreshing
        _swipeRefreshing.value = true

        loadCities(true)
    }

    override fun loadCities(forceReload: Boolean) {

        // Fetch data and revert
        viewModelScope.launch {
            //Show Loading State in UI
            //_state.value = CityListViewState.Loading
            _swipeRefreshing.value = true

            try {
                getCitiesUseCase(forceReload).data
                    ?.let {

                        // Set Screen State
                        _state.value = if (it.isNotEmpty())
                            CityListViewState.Loaded
                        else
                            CityListViewState.Empty

                        _cityList.value = it

                    }

            } catch (e: Exception) {
                _state.value =
                    CityListViewState.Error
            }

            _swipeRefreshing.value = false
        }
    }

    override fun openCityDetails(city: City) {
        _openCityDetailsEvent.value = Event(city)
    }

    // ============================================================================================
    //  Public methods
    // ============================================================================================

    /**
     * Set Current View State
     */
    fun setOfflineState() {
        _state.value =
            CityListViewState.Offline
    }

    init {

        // Load Seed Data
        loadCities()
    }

}
