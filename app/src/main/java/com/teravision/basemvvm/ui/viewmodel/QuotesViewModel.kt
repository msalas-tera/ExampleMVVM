package com.teravision.basemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.teravision.basemvvm.data.model.Quote
import com.teravision.basemvvm.data.repository.QuotesRepository
import kotlinx.coroutines.launch

class QuotesViewModel(private val quotesRepository: QuotesRepository) : BaseViewModel() {

    val onSuccess = MutableLiveData<Quote>()
    val onError = MutableLiveData<String>()

    init {
        getQuotes()
    }

    fun getQuotes() = viewModelScope.launch {
        getQuotesAsync()
    }

    private suspend fun getQuotesAsync() {
        val result = runCatching {
            showLoading()
            quotesRepository.getQuotes()
        }

        with(result) {
            dismissLoading()
            onSuccess { response ->
                response.body()?.contents?.quotes?.let { quotes ->
                    onSuccess.postValue(quotes.random())
                } ?: onError.postValue("Error")
            }
            onFailure {
                onError.postValue(it.message.toString())
            }
        }
    }

}