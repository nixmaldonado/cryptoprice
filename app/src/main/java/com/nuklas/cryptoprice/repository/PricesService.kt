package com.nuklas.cryptoprice.repository

import com.nuklas.cryptoprice.model.CurrencyQuotation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PricesService {
    @GET("v1/ticker")
    fun getPrices(): Call<List<CurrencyQuotation>>

    @GET("v1/ticker/{currencyName}")
    fun getPrice(@Path("currencyName") currencyName : String) : Call<List<CurrencyQuotation>>
}