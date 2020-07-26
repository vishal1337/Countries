package com.v15h4l.vishalpoc.ui.country_list.di

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerFragment
import com.v15h4l.vishalpoc.ui.country_list.view.CountryListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CountryListFragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideCountryListFragment(): CountryListFragment

}