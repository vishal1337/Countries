package com.v15h4l.vishalpoc.common.di.coroutine

import com.v15h4l.vishalpoc.common.di.config.qualifier.DefaultDispatcher
import com.v15h4l.vishalpoc.common.di.config.qualifier.IoDispatcher
import com.v15h4l.vishalpoc.common.di.config.qualifier.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Module ot provide Coroutine Dispatchers.
 */
@Module
object CoroutinesModule {

    @DefaultDispatcher
    @JvmStatic
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @JvmStatic
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @JvmStatic
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
