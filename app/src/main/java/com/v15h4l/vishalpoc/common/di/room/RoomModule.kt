package com.v15h4l.vishalpoc.common.di.room

import android.content.Context
import androidx.room.Room
import com.v15h4l.vishalpoc.common.utils.Common.DATABASE_NAME
import com.v15h4l.vishalpoc.data.country.local.CountryDao
import com.v15h4l.vishalpoc.data.country.local.CountryDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideCountryDatabase(context: Context): CountryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CountryDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCountryDao(countryDatabase: CountryDatabase): CountryDao =
        countryDatabase.countryDao()

}