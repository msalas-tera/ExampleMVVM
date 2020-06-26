package com.teravision.basemvvm.application

import android.app.Application
import com.teravision.basemvvm.di.networkModule
import com.teravision.basemvvm.di.repoModule
import com.teravision.basemvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    private val appModules = listOf(viewModelModule, networkModule, repoModule)

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                appModules
            )
        }
    }
}