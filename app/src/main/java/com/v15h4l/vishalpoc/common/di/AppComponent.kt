package com.v15h4l.vishalpoc.common.di

import android.content.Context
import com.v15h4l.vishalpoc.Application
import com.v15h4l.vishalpoc.common.di.app.AppModule
import com.v15h4l.vishalpoc.common.di.coroutine.CoroutinesModule
import com.v15h4l.vishalpoc.common.di.network.NetworkModule
import com.v15h4l.vishalpoc.common.di.room.RoomModule
import com.v15h4l.vishalpoc.common.di.ui.MainModule
import com.v15h4l.vishalpoc.common.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        CoroutinesModule::class,
        NetworkModule::class,
        RoomModule::class,
        ViewModelModule::class,
        MainModule::class
    ]
)

interface AppComponent : AndroidInjector<Application> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}