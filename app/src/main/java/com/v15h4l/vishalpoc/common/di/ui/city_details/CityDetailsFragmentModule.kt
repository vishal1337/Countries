package com.v15h4l.vishalpoc.common.di.ui.city_details

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerFragment
import com.v15h4l.vishalpoc.ui.city_details.CityDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CityDetailsFragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideCityDetailsFragment(): CityDetailsFragment

}