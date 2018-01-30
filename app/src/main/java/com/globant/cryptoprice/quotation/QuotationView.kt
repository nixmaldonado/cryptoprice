package com.globant.cryptoprice.quotation

import android.support.v7.widget.RecyclerView
import android.view.View
import com.globant.cryptoprice.quotation.QuotationAdapter

class QuotationView(val view: View, val adapter: QuotationAdapter) : RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        adapter.getCurrencyQuotation(this.adapterPosition)
    }

}

