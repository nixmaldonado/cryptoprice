package com.globant.cryptoprice.quotation

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.globant.cryptoprice.R
import com.globant.cryptoprice.model.CurrencyQuotation
import kotlinx.android.synthetic.main.currency_item.view.*
import java.text.NumberFormat

class QuotationAdapter(var array: List<CurrencyQuotation>) : RecyclerView.Adapter<QuotationView>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuotationView {
        val inflater = LayoutInflater.from(parent?.context)
        val rowView = inflater.inflate(R.layout.currency_item, parent, false)
        return QuotationView(rowView, this)
    }

    override fun onBindViewHolder(holder: QuotationView?, position: Int) {

        val price = array[position].price_usd.toDouble()
        val name = array[position].name
        val percentageChangeHour = array[position].percent_change_1h.toDouble()
        val percentageChangeDay = array[position].percent_change_24h.toDouble()
        val percentageChangeWeek = array[position].percent_change_7d.toDouble()

        val formatter = NumberFormat.getCurrencyInstance()

        holder?.view?.name?.text = name
        holder?.view?.price?.text = formatter.format(price)
        holder?.view?.percentage_variation_hour?.text = "1h: $percentageChangeHour %"
        holder?.view?.percentage_variation_day?.text = "24h: $percentageChangeDay %"
        holder?.view?.percentage_variation_week?.text = "7d: $percentageChangeWeek %"

        if (percentageChangeWeek >= 0) {
            holder?.view?.percentage_variation_week?.setTextColor(Color.parseColor("#49ce40"))
        } else {
            holder?.view?.percentage_variation_week?.setTextColor(Color.RED)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun getCurrencyQuotation(postion : Int): CurrencyQuotation {
        return array[postion]
    }
}