package com.v15h4l.vishalpoc.ui.country_list.view

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
import com.v15h4l.vishalpoc.databinding.FragmentCountryListBinding
import com.v15h4l.vishalpoc.model.Country
import com.v15h4l.vishalpoc.result.EventObserver
import com.v15h4l.vishalpoc.ui.country_list.model.CountryAdapter
import com.v15h4l.vishalpoc.ui.country_list.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.fragment_country_list.*
import kotlinx.android.synthetic.main.fragment_country_list.view.*
import javax.inject.Inject

class CountryListFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var countryListViewModel: CountryListViewModel

    private val countryListAdapter by lazy { CountryAdapter(countryListViewModel) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        countryListViewModel = viewModelProvider(viewModelFactory)

        // Inflate the layout for this fragment
        val binding = FragmentCountryListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = countryListViewModel
        }

        countryListViewModel.countryList.observe(viewLifecycleOwner, Observer { countryList ->
            countryListAdapter.submitList(countryList)
        })

        countryListViewModel.openCountryDetailsEvent.observe(
            viewLifecycleOwner,
            EventObserver { country ->
                openCountryDetails(country)
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
            String.format(resources.getString(R.string.label_country_list, BuildConfig.REGION))

        // Init RecyclerView
        rvCountries.adapter = countryListAdapter

        // Don't Load data upon Screen Rotation if the Data is already loaded or still loading
        if (countryListViewModel.stateList.value != CountryListViewState.Loaded
            && countryListViewModel.stateList.value != CountryListViewState.Loading
        ) {
            countryListViewModel.loadCountries(isConnected(requireContext()).not())
        }

    }

    /**
     * Navigation
     */
    private fun openCountryDetails(country: Country) {
        val action =
            CountryListFragmentDirections
                .actionCountryListFragmentToCountryDetailsFragment(country)
        findNavController().navigate(action)
    }
}
