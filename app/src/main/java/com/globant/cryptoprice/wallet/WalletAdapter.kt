package com.globant.cryptoprice.wallet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globant.cryptoprice.R
import com.globant.cryptoprice.model.CryptoCurrency
import com.globant.cryptoprice.utils.CustomView

class WalletAdapter(private val currencyList: List<CryptoCurrency>) : RecyclerView.Adapter<CustomView>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomView {
        val inflater = LayoutInflater.from(parent?.context)
        val rowView = inflater.inflate(R.layout.wallet_item, parent, false)
        return CustomView(rowView)
    }

    override fun onBindViewHolder(holder: CustomView?, position: Int) {
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }
}
