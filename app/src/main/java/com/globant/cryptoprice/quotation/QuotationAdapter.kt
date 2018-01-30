package com.globant.cryptoprice.quotation

import android.content.Context
import android.graphics.Color


import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity



import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globant.cryptoprice.DetailActivity
import com.globant.cryptoprice.R
import com.globant.cryptoprice.model.CurrencyQuotation
import kotlinx.android.synthetic.main.currency_item.view.*
import java.text.NumberFormat

class QuotationAdapter(var array: List<CurrencyQuotation>, val context : Context) : RecyclerView.Adapter<QuotationView>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuotationView {
        val inflater = LayoutInflater.from(parent?.context)
        val rowView = inflater.inflate(R.layout.currency_item, parent, false)
        return QuotationView(rowView, this)
    }

    override fun onBindViewHolder(holder: QuotationView?, position: Int) {

        val price = array[position].price_usd.toDouble()
        val name = array[position].name

        val formatter = NumberFormat.getCurrencyInstance()

        holder?.view?.name?.text = name
        holder?.view?.price?.text = formatter.format(price)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun getCurrencyQuotation(position: Int): CurrencyQuotation {
        return array[position]
    }

    fun startDetailActivity(currency: CurrencyQuotation){
        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra("CURRENCY_POSITION", currency)
        }
        startActivity(context, intent, Bundle.EMPTY)
    }
}