package com.globant.cryptoprice.buycurrency

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.globant.cryptoprice.R
import com.globant.cryptoprice.utils.CustomView
import kotlinx.android.synthetic.main.buy_currency_item.view.*

class BuyAdapter : RecyclerView.Adapter<CustomView>() {

    var checkedView : View? = null
    var selectedCurrency : String? = null

    private val currencies = arrayListOf("Bitcoin", "Ethereum", "Ripple",
            "Salt", "Cardano", "Litecoin", "Steem", "NEO", "Stellar", "Dogecoin")

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomView {
        val inflater = LayoutInflater.from(parent?.context)
        val rowView = inflater.inflate(R.layout.buy_currency_item, parent, false)
        rowView.setOnClickListener({
            rowView.radio_button.isChecked = !rowView.radio_button.isChecked
            if(rowView.radio_button.isChecked && rowView != checkedView){
                checkedView?.radio_button?.isChecked = false
                checkedView = rowView
                selectedCurrency = rowView.currency_name.text.toString()
            }
        })
        return CustomView(rowView)
    }

    override fun onBindViewHolder(holder: CustomView?, position: Int) {
        holder?.view?.currency_name?.text = currencies[position]
    }

    override fun getItemCount(): Int {
        return currencies.size
    }
}
