package com.teravision.basemvvm.di

import com.teravision.basemvvm.data.api.api_service.RetrofitFactory
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitFactory().makeApiService() }
}