package com.globant.cryptoprice.repository

import android.arch.lifecycle.MutableLiveData
import com.globant.cryptoprice.model.CurrencyQuotation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PricesRepository {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service = retrofit.create(PricesService::class.java)

    val data = MutableLiveData<List<CurrencyQuotation>>()

    fun getPrices(): MutableLiveData<List<CurrencyQuotation>> {

        service.getPrices().enqueue(object : Callback<List<CurrencyQuotation>> {
            override fun onResponse(call: Call<List<CurrencyQuotation>>, response: Response<List<CurrencyQuotation>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<CurrencyQuotation>>?, t: Throwable?) {

            }
        })
        return data
    }
}