package com.v15h4l.vishalpoc.common.di.network

import com.v15h4l.vishalpoc.BuildConfig
import com.v15h4l.vishalpoc.common.di.config.qualifier.LocalCountryDataSource
import com.v15h4l.vishalpoc.common.di.config.qualifier.RemoteCountryDataSource
import com.v15h4l.vishalpoc.data.country.CountryDataSource
import com.v15h4l.vishalpoc.data.country.CountryRepository
import com.v15h4l.vishalpoc.data.country.local.CountryDao
import com.v15h4l.vishalpoc.data.country.local.CountryLocalDataSource
import com.v15h4l.vishalpoc.data.country.remote.CountryRemoteDataSource
import com.v15h4l.vishalpoc.data.country.remote.CountryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun providesOkHttpClient(
        okHttpClientBuilder: OkHttpClient.Builder,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {


        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }

        okHttpClientBuilder
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("x-rapidapi-host", BuildConfig.X_RAPIDAPI_HOST)
                        .addHeader("x-rapidapi-key", BuildConfig.X_RAPIDAPI_KEY)
                        .addHeader("useQueryString", BuildConfig.USE_QUERY_STRING)
                        .build()
                )
            }

        return okHttpClientBuilder.build()
    }

    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides
    fun provideCountryService(retrofit: Retrofit): CountryService =
        retrofit.create(CountryService::class.java)

    @Singleton
    @LocalCountryDataSource
    @Provides
    fun provideCountryLocalDataSource(countryDao: CountryDao): CountryDataSource =
        CountryLocalDataSource(countryDao)

    @Singleton
    @RemoteCountryDataSource
    @Provides
    fun provideCountryRemoteDataSource(countryService: CountryService): CountryDataSource =
        CountryRemoteDataSource(countryService)

    @Provides
    fun provideCountryRepository(
        localDataSource: CountryLocalDataSource,
        remoteDataSource: CountryRemoteDataSource
    ): CountryRepository = CountryRepository(localDataSource, remoteDataSource)

}