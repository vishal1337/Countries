package com.v15h4l.vishalpoc.common.di.config.qualifier

import javax.inject.Qualifier

/**
 * Default Dispatcher
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

/**
 * Io Dispatcher
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

/**
 * Main Dispatcher
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher
