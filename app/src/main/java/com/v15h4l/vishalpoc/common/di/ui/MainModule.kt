package com.v15h4l.vishalpoc.common.di.ui

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerActivity
import com.v15h4l.vishalpoc.ui.MainActivity
import com.v15h4l.vishalpoc.ui.country_details.di.CountryDetailsFragmentModule
import com.v15h4l.vishalpoc.ui.country_list.di.CountryListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            CountryListFragmentModule::class,
            CountryDetailsFragmentModule::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity

}