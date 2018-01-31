package com.globant.cryptoprice

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.globant.cryptoprice.model.CurrencyQuotation
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.NumberFormat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val currency = intent.extras.getParcelable<CurrencyQuotation>("CURRENCY_POSITION")

        name.text = currency.name
        symbol.text = currency.symbol
        val formatter = NumberFormat.getCurrencyInstance()
        price.text = "${formatter.format(currency.price_usd.toDouble())}"

        percentage_variation_week.text = "7 Días: ${currency.percent_change_7d} %"
        percentage_variation_week.setTextColor(getVariationColor(currency.percent_change_7d.toDouble()))
        percentage_variation_hour.text = "1 Hora: ${currency.percent_change_1h} %"
        percentage_variation_hour.setTextColor(getVariationColor(currency.percent_change_1h.toDouble()))
        percentage_variation_day.text = "24 Horas: ${currency.percent_change_24h} %"
        percentage_variation_day.setTextColor(getVariationColor(currency.percent_change_24h.toDouble()))
    }

    private fun getVariationColor(variation : Double): Int {
        return if(variation >= 0) Color.parseColor("#49ce40") else Color.RED
    }
}
