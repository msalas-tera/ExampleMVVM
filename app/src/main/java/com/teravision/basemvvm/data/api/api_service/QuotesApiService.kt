package com.teravision.basemvvm.data.api.api_service

import com.teravision.basemvvm.data.api.model.response.QuotesResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiService {
    @GET("qod")
    suspend fun getQuotes(): Response<QuotesResponseBody>
}
