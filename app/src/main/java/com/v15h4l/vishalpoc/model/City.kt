package com.v15h4l.vishalpoc.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.v15h4l.vishalpoc.common.utils.joinOrNa
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    /** Numeric Code will work as a Unique Identifier **/
    @SerializedName("numericCode") val numericCode: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("topLevelDomain") val topLevelDomain: List<String> = listOf(),
    @SerializedName("alpha2Code") val alpha2Code: String = "",
    @SerializedName("alpha3Code") val alpha3Code: String = "",
    @SerializedName("callingCodes") val callingCodes: List<String> = listOf(),
    @SerializedName("capital") val capital: String = "",
    @SerializedName("altSpellings") val altSpellings: List<String> = listOf(),
    @SerializedName("region") val region: String = "",
    @SerializedName("subregion") val subRegion: String = "",
    @SerializedName("population") val population: Int = 0,
    @SerializedName("latlng") val latLng: List<Double> = listOf(),
    @SerializedName("demonym") val demonym: String = "",
    @SerializedName("area") val area: Double = 0.0,
    @SerializedName("gini") val gini: Double = 0.0,
    @SerializedName("timezones") val timezones: List<String> = listOf(),
    @SerializedName("borders") val borders: List<String> = listOf(),
    @SerializedName("nativeName") val nativeName: String = "",
    @SerializedName("currencies") val currencies: List<String> = listOf(),
    @SerializedName("languages") val languages: List<String> = listOf(),
    @SerializedName("translations") val translations: Translations = Translations(),
    @SerializedName("relevance") val relevance: String = ""
) : Parcelable {

    @Parcelize
    data class Translations(
        @SerializedName("de") val de: String = "",
        @SerializedName("es") val es: String = "",
        @SerializedName("fr") val fr: String = "",
        @SerializedName("ja") val ja: String = "",
        @SerializedName("it") val it: String = ""
    ) : Parcelable

    fun getDescription(): String =
        "Capital: $capital\nPopulation: $population\nCurrency: ${currencies.joinOrNa(", ")}"

    fun getSimplifiedLatLong() = latLng.map { it.toString() }.joinOrNa(",")

    fun getSimplifiedBorders() = borders.joinOrNa(", ")

    fun getSimplifiedLanguages() = languages.joinOrNa(", ")
}