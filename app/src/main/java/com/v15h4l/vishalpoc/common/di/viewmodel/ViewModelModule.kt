package com.v15h4l.vishalpoc.common.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.v15h4l.vishalpoc.common.di.config.qualifier.ViewModelKey
import com.v15h4l.vishalpoc.ui.city_list.viewmodel.CityListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CityListViewModel::class)
    internal abstract fun bindCityListViewModel(viewModel: CityListViewModel): ViewModel

}