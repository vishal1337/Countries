package com.v15h4l.vishalpoc.common.di.app

import android.content.Context
import android.content.res.Resources
import com.v15h4l.vishalpoc.Application
import com.v15h4l.vishalpoc.common.di.config.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @ApplicationContext
    @Binds
    abstract fun provideApplicationContext(app: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppResources(context: Context): Resources = context.resources
    }
}