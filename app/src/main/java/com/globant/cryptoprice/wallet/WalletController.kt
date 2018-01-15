package com.globant.cryptoprice.wallet

import com.globant.cryptoprice.model.AppDatabase
import com.globant.cryptoprice.model.CryptoCurrency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WalletController(private val view: WalletFragment) : Callback<List<CryptoCurrency>> {

    lateinit var adapter: WalletAdapter

    private lateinit var list: List<CryptoCurrency>

    fun start() {
        var database = AppDatabase.getAppDatabase(view.context)

        list = database.currencyDao().getAll()

        adapter = WalletAdapter(list)
    }

    override fun onResponse(call: Call<List<CryptoCurrency>>?, response: Response<List<CryptoCurrency>>?) {
    }

    override fun onFailure(call: Call<List<CryptoCurrency>>?, t: Throwable?) {
    }
}