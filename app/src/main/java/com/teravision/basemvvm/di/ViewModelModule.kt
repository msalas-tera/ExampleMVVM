package com.teravision.basemvvm.di

import com.teravision.basemvvm.ui.viewmodel.QuotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { QuotesViewModel(get()) }
}

