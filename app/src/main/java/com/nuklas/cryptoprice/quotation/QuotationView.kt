package com.nuklas.cryptoprice.quotation

import android.support.v7.widget.RecyclerView
import android.view.View

class QuotationView(val view: View, val adapter: QuotationAdapter) : RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        val currency = adapter.getCurrencyQuotation(this.adapterPosition)
        adapter.startDetailActivity(currency)
    }

}

