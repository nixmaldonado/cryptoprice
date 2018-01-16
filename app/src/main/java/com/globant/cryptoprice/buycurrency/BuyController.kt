package com.globant.cryptoprice.buycurrency

import com.globant.cryptoprice.model.AppDatabase
import com.globant.cryptoprice.model.CryptoCurrency
import com.globant.cryptoprice.model.CurrencyQuotation
import com.globant.cryptoprice.repository.PricesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuyController(private val activity: BuyCurrencyActivity): Callback<CurrencyQuotation> {

    lateinit var adapter: BuyAdapter
    lateinit var amountToBuy : String

    private lateinit var service : PricesService

    fun start(){
        adapter = BuyAdapter()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(PricesService::class.java)
    }

    fun buyCurrency(currency: String?, amountToBuy: String) {
        this.amountToBuy = amountToBuy
        service.getPrice(currency?.toLowerCase()!!).enqueue(this)
    }

    override fun onResponse(call: Call<CurrencyQuotation>?, response: Response<CurrencyQuotation>?) {
        val quotation = response?.body()
        val currentPrice = quotation?.price_usd?.toFloat()!! / amountToBuy.toFloat()
        val newCurrency = CryptoCurrency()
        newCurrency.amount = currentPrice.toString()
        val database = AppDatabase.getAppDatabase(activity)
        database.currencyDao().insertAll(newCurrency)
        activity.finish()
    }

    override fun onFailure(call: Call<CurrencyQuotation>?, t: Throwable?) {
    }
}