package com.v15h4l.vishalpoc.common.di.ui.city_list

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerFragment
import com.v15h4l.vishalpoc.ui.city_list.view.CityListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CityListFragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideCityListFragment(): CityListFragment

}