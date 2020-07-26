package com.v15h4l.vishalpoc.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.v15h4l.vishalpoc.common.utils.joinOrNa
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "countries")
data class Country @JvmOverloads constructor(
    @PrimaryKey val numericCode: String = "",
    var name: String = "",
    var capital: String = "",
    var region: String = "",
    var population: Int = 0,
    var latLong: List<Double> = listOf(),
    var borders: List<String> = listOf(),
    var currencies: List<String> = listOf(),
    var languages: List<String> = listOf()
) : Parcelable {
    fun getDescription(): String =
        "Capital: $capital\nPopulation: $population\nCurrency: ${currencies.joinOrNa(", ")}"

    fun getSimplifiedLatLong() = latLong.map { it.toString() }.joinOrNa(",")

    fun getSimplifiedBorders() = borders.joinOrNa(", ")

    fun getSimplifiedLanguages() = languages.joinOrNa(", ")
}