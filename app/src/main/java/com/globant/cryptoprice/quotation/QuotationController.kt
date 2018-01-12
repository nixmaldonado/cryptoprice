package com.globant.cryptoprice.quotation

import com.globant.cryptoprice.model.CurrencyQuotation
import com.globant.cryptoprice.repository.PricesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotationController(private val fragment: QuotationFragment) : Callback<List<CurrencyQuotation>> {

    lateinit var adapter: RecyclerAdapter

    private var list: List<CurrencyQuotation> = ArrayList()

    fun start() {
        fragment.showProgressBar()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(PricesService::class.java)

        adapter = RecyclerAdapter(list)

        service.getPrices().enqueue(this)
    }

    override fun onResponse(call: Call<List<CurrencyQuotation>>?, response: Response<List<CurrencyQuotation>>?) {
        adapter.array = response?.body()!!
        adapter.notifyDataSetChanged()
        fragment.hideProgressBar()

    }

    override fun onFailure(call: Call<List<CurrencyQuotation>>?, t: Throwable?) {

    }
}