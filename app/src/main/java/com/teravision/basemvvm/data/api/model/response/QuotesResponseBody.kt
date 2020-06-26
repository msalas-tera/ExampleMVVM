package com.teravision.basemvvm.data.api.model.response


import com.teravision.basemvvm.data.model.Quote

data class QuotesResponseBody(
    val contents: Contents? = null,
    val success: Success? = null,
    val error: Error? = null
) {
    data class Contents(
        val quotes: List<Quote>? = null
    )

    data class Success(
        val total: Int? = null
    )

    data class Error(
        val code: Int? = null,
        val message: String? = null
    )
}