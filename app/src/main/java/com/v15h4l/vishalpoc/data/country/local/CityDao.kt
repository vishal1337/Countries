package com.v15h4l.vishalpoc.data.country.local

import androidx.room.*
import com.v15h4l.vishalpoc.model.Country

/**
 * Data Access Object for the countries table.
 */
@Dao
interface CountryDao {

    @Query("SELECT * FROM Countries")
    fun getCountries(): List<Country>

    @Query("SELECT * FROM countries WHERE region = :region")
    fun getCountriesByRegion(region: String): List<Country>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(country: Country)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<Country>)

    @Update
    fun updateCountry(country: Country): Int

    @Query("DELETE FROM countries WHERE numericCode = :numericCode")
    fun deleteCountryById(numericCode: String): Int

    @Query("DELETE FROM countries")
    fun deleteCountries()

}