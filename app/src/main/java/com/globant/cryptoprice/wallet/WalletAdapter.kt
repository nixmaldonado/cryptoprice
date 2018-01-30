package com.globant.cryptoprice.wallet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globant.cryptoprice.R
import com.globant.cryptoprice.model.CryptoCurrency
import kotlinx.android.synthetic.main.wallet_item.view.*

class WalletAdapter(private val currencyList: List<CryptoCurrency>) : RecyclerView.Adapter<WalletView>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WalletView {
        val inflater = LayoutInflater.from(parent?.context)
        val rowView = inflater.inflate(R.layout.wallet_item, parent, false)
        return WalletView(rowView)
    }

    override fun onBindViewHolder(holder: WalletView?, position: Int) {
        holder?.view?.currency_name?.text = currencyList[position].name
        holder?.view?.currency_amount?.text = currencyList[position].amount
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }
}
