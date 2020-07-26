package com.v15h4l.vishalpoc.ui.country_details.di

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerFragment
import com.v15h4l.vishalpoc.ui.country_details.view.CountryDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CountryDetailsFragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideCountryDetailsFragment(): CountryDetailsFragment

}