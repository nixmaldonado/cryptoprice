package com.globant.cryptoprice.wallet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globant.cryptoprice.R
import com.globant.cryptoprice.model.CryptoCurrency
import com.globant.cryptoprice.utils.CustomView
import kotlinx.android.synthetic.main.wallet_item.view.*


class WalletAdapter(private var array: List<CryptoCurrency>) : RecyclerView.Adapter<CustomView>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomView {
        val rowView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.wallet_item, parent, false)

        return CustomView(rowView)
    }

    override fun onBindViewHolder(holder: CustomView?, position: Int) {
        holder?.view?.name?.text = array[position].name
        holder?.view?.currency_amount?.text = array[position].amount
    }

    override fun getItemCount(): Int {
        return array.size
    }
}
