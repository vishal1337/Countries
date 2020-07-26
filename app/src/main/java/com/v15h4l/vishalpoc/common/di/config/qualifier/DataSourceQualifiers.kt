package com.v15h4l.vishalpoc.common.di.config.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalCountryDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteCountryDataSource