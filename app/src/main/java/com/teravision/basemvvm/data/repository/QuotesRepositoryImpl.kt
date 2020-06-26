package com.teravision.basemvvm.data.repository

import com.teravision.basemvvm.data.api.api_service.QuotesApiService

class QuotesRepositoryImpl(private val quotesApiService: QuotesApiService) : QuotesRepository {

    override suspend fun getQuotes() =
        quotesApiService.getQuotes()

}