package com.nuklas.cryptoprice.buycurrency

import com.nuklas.cryptoprice.model.AppDatabase
import com.nuklas.cryptoprice.model.CryptoCurrency
import com.nuklas.cryptoprice.model.CurrencyQuotation
import com.nuklas.cryptoprice.repository.PricesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuyController(private val activity: BuyCurrencyActivity): Callback<List<CurrencyQuotation>> {

    lateinit var adapter: BuyAdapter
    lateinit var amountToBuy: String
    private lateinit var service: PricesService

    fun start() {
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

    override fun onResponse(call: Call<List<CurrencyQuotation>>?, response: Response<List<CurrencyQuotation>>?) {
        val quotation = response?.body()?.get(0)
        val amountToBuy = amountToBuy.toFloat() / quotation?.price_usd?.toFloat()!!
        val newCurrency = CryptoCurrency()
        newCurrency.amount = amountToBuy.toString()
        newCurrency.name = quotation.name
        addNewTransaction(newCurrency)

        activity.finish()
    }

    private fun addNewTransaction(newCurrency: CryptoCurrency) {
        val database = AppDatabase.getAppDatabase(activity).currencyDao()
        val currencyList = database.getCurrency(newCurrency.name)
        if(currencyList.isEmpty()) {
            database.insertAll(newCurrency)
        }else{
            newCurrency.amount = (newCurrency.amount.toFloat() + currencyList[0].amount.toDouble()).toString()
            database.updateCurrency(newCurrency.name, newCurrency.amount)
        }
    }

    override fun onFailure(call: Call<List<CurrencyQuotation>>?, t: Throwable?) {
        activity.toastMessage("OMG! Something went wOrng!")
    }
}
