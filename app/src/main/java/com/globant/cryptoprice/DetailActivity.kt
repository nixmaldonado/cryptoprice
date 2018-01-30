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

        var percentageChangeWeek = currency.percent_change_7d.toDouble()

        if (percentageChangeWeek >= 0) {
            percentage_variation_week.setTextColor(Color.parseColor("#49ce40"))
        } else {
            percentage_variation_week.setTextColor(Color.RED)
        }

        percentage_variation_week.text = "7 Días: ${percentageChangeWeek.toString()} %"
        percentage_variation_hour.text = "1 Hora: ${currency.percent_change_1h} %"
        percentage_variation_day.text = "24 Horas: ${currency.percent_change_24h} %"

    }
}
