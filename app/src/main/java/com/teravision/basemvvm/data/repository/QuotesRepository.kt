package com.teravision.basemvvm.data.repository

import androidx.lifecycle.viewModelScope
import com.teravision.basemvvm.data.api.model.response.QuotesResponseBody
import com.teravision.basemvvm.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Response

interface QuotesRepository {
    suspend fun getQuotes(): Response<QuotesResponseBody>
}