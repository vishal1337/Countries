package com.v15h4l.vishalpoc.ui.country_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.v15h4l.vishalpoc.common.base.BaseFragment
import com.v15h4l.vishalpoc.databinding.FragmentCountryDetailsBinding
import com.v15h4l.vishalpoc.model.Country
import kotlinx.android.synthetic.main.fragment_country_details.view.*
import javax.inject.Inject

class CountryDetailsFragment @Inject constructor() : BaseFragment() {

    private val countryArg: Country?
        get() = arguments?.let {
            CountryDetailsFragmentArgs.fromBundle(it).country
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentCountryDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            country = countryArg
        }

        binding.appbar.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

}
