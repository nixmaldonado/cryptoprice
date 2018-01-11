package com.globant.cryptoprice

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.globant.cryptoprice.model.CurrencyQuotation
import com.globant.cryptoprice.repository.PricesRepository

class CurrenciesViewModel(repository: PricesRepository) : ViewModel() {

    private var repository: PricesRepository? = null
    private var currencyList: MutableLiveData<List<CurrencyQuotation>>? = null

    init {
        this.repository = repository
    }

    fun init() {

        if (currencyList != null) {
            return
        }
        currencyList = repository?.getPrices()

    }

    fun getCurrentCurrencyList(): MutableLiveData<List<CurrencyQuotation>>? {
        return currencyList
    }
}