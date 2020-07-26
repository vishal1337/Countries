package com.v15h4l.vishalpoc.data.country.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.v15h4l.vishalpoc.model.Country

/**
 * The Room Database that contains the Country table.
 */
@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

}