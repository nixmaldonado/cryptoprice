package com.globant.cryptoprice.wallet

import com.globant.cryptoprice.model.CryptoCurrency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WalletController(private val fragment: WalletFragment) : Callback<List<CryptoCurrency>> {

    lateinit var adapter: WalletAdapter

    private lateinit var list: List<CryptoCurrency>

    fun start() {
        val currency = CryptoCurrency()
        currency.amount = "1"
        currency.name = "Bitcoin"
        list = arrayListOf(currency)
        adapter = WalletAdapter(list)
    }

    override fun onResponse(call: Call<List<CryptoCurrency>>?, response: Response<List<CryptoCurrency>>?) {
    }

    override fun onFailure(call: Call<List<CryptoCurrency>>?, t: Throwable?) {
    }
}