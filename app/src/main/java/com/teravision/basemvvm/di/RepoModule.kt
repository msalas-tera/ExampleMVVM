package com.teravision.basemvvm.di

import com.teravision.basemvvm.data.repository.QuotesRepository
import com.teravision.basemvvm.data.repository.QuotesRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    factory<QuotesRepository> { QuotesRepositoryImpl(get()) }
}