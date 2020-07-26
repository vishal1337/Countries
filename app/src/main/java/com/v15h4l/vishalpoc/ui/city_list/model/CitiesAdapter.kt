package com.v15h4l.vishalpoc.ui.city_list.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.v15h4l.vishalpoc.databinding.ItemCityBinding
import com.v15h4l.vishalpoc.model.City
import com.v15h4l.vishalpoc.ui.city_list.viewmodel.CityListViewModel

class CitiesAdapter(private val cityListViewModel: CityListViewModel) :
    ListAdapter<City, CityViewHolder>(CityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder =
        CityViewHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), cityListViewModel
        )

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CityViewHolder(
    private val binding: ItemCityBinding,
    private val cityListViewModel: CityListViewModel
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(city: City) {
        binding.city = city
        binding.viewModel = cityListViewModel
        binding.executePendingBindings()
    }
}

private class CityDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(
        oldItem: City,
        newItem: City
    ): Boolean =
        oldItem.numericCode == newItem.numericCode

    override fun areContentsTheSame(
        oldItem: City,
        newItem: City
    ): Boolean =
        oldItem.toString() == newItem.toString()

}