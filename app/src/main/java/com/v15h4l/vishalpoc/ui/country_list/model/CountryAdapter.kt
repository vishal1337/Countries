package com.v15h4l.vishalpoc.ui.country_list.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.v15h4l.vishalpoc.databinding.ItemCountryBinding
import com.v15h4l.vishalpoc.model.Country
import com.v15h4l.vishalpoc.ui.country_list.viewmodel.CountryListViewModel

class CountryAdapter(private val countryListViewModel: CountryListViewModel) :
    ListAdapter<Country, CountryViewHolder>(CountryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), countryListViewModel
        )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CountryViewHolder(
    private val binding: ItemCountryBinding,
    private val countryListViewModel: CountryListViewModel
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(country: Country) {
        binding.country = country
        binding.viewModel = countryListViewModel
        binding.executePendingBindings()
    }
}

private class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(
        oldItem: Country,
        newItem: Country
    ): Boolean =
        oldItem.numericCode == newItem.numericCode

    override fun areContentsTheSame(
        oldItem: Country,
        newItem: Country
    ): Boolean =
        oldItem.toString() == newItem.toString()

}