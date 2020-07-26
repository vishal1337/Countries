package com.v15h4l.vishalpoc.ui.city_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.v15h4l.vishalpoc.common.base.BaseFragment
import com.v15h4l.vishalpoc.databinding.FragmentCityDetailsBinding
import com.v15h4l.vishalpoc.model.City
import kotlinx.android.synthetic.main.fragment_city_details.view.*
import javax.inject.Inject

class CityDetailsFragment @Inject constructor() : BaseFragment() {

    private val cityArg: City?
        get() = arguments?.let { CityDetailsFragmentArgs.fromBundle(it).city }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentCityDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            city = cityArg
        }

        binding.appbar.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

}
