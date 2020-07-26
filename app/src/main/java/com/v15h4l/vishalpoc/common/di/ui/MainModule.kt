package com.v15h4l.vishalpoc.common.di.ui

import com.v15h4l.vishalpoc.common.di.config.qualifier.PerActivity
import com.v15h4l.vishalpoc.common.di.ui.city_details.CityDetailsFragmentModule
import com.v15h4l.vishalpoc.common.di.ui.city_list.CityListFragmentModule
import com.v15h4l.vishalpoc.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            CityListFragmentModule::class,
            CityDetailsFragmentModule::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity

}