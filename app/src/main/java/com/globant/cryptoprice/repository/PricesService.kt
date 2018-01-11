package com.globant.cryptoprice.repository

import com.globant.cryptoprice.model.CurrencyQuotation
import retrofit2.Call
import retrofit2.http.GET

interface PricesService {
    @GET("v1/ticker/?limit=10")
    fun getPrices(): Call<List<CurrencyQuotation>>
}