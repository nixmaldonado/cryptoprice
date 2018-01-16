package com.globant.cryptoprice.buycurrency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.globant.cryptoprice.R
import kotlinx.android.synthetic.main.activity_buy_currency.*

class BuyCurrencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_currency)

        val controller = BuyController(this)

        controller.start()

        val manager = LinearLayoutManager(this)
        currency_list.layoutManager = manager
        currency_list.adapter = controller.adapter

        buy_button.setOnClickListener({
            controller.buyCurrency(controller.adapter.selectedCurrency, amount_to_buy.text.toString())
        })
    }
}
