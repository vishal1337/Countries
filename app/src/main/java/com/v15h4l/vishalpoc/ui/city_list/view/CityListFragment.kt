package com.v15h4l.vishalpoc.ui.city_list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.v15h4l.vishalpoc.BuildConfig
import com.v15h4l.vishalpoc.R
import com.v15h4l.vishalpoc.common.base.BaseFragment
import com.v15h4l.vishalpoc.common.utils.isConnected
import com.v15h4l.vishalpoc.common.utils.viewModelProvider
import com.v15h4l.vishalpoc.databinding.FragmentCityListBinding
import com.v15h4l.vishalpoc.model.City
import com.v15h4l.vishalpoc.result.EventObserver
import com.v15h4l.vishalpoc.ui.city_list.model.CitiesAdapter
import com.v15h4l.vishalpoc.ui.city_list.viewmodel.CityListViewModel
import kotlinx.android.synthetic.main.fragment_city_list.*
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import javax.inject.Inject

class CityListFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var cityListViewModel: CityListViewModel

    private val cityListAdapter by lazy { CitiesAdapter(cityListViewModel) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        cityListViewModel = viewModelProvider(viewModelFactory)

        // Inflate the layout for this fragment
        val binding = FragmentCityListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = cityListViewModel
        }

        cityListViewModel.cityList.observe(viewLifecycleOwner, Observer { cityList ->
            cityListAdapter.submitList(cityList)
        })

        cityListViewModel.openCityDetailsEvent.observe(viewLifecycleOwner, EventObserver { city ->
            openCityDetails(city)
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        // Show Select Region in title
        appbar.toolbar.title =
            String.format(resources.getString(R.string.label_city_list, BuildConfig.REGION))

        // Init RecyclerView
        rvCities.adapter = cityListAdapter

        buttonRetry.setOnClickListener { forceFetchData() }

        // Init Toolbar
        /*appbar.toolbar.let {
            it.inflateMenu(R.menu.menu_cities)
            it.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_filter -> { /* Show Filter UI */}
                }
                true
            }
        }*/
    }

    private fun forceFetchData() {

        if (isConnected(requireContext()).not()) {
            cityListViewModel.setOfflineState()
            return
        }

        cityListViewModel.loadCities()

    }

    /**
     * Navigation
     */
    private fun openCityDetails(city: City) {
        val action =
            CityListFragmentDirections
                .actionCityListFragmentToCityDetailsFragment(city)
        findNavController().navigate(action)
    }
}
