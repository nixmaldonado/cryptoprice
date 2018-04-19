package com.nuklas.cryptoprice.buycurrency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.nuklas.cryptoprice.R
import kotlinx.android.synthetic.main.activity_buy_currency.*

class BuyCurrencyActivity : AppCompatActivity() {

    private lateinit var controller: BuyController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_currency)

        controller = BuyController(this)

        controller.start()

        val manager = LinearLayoutManager(this)
        currency_list.layoutManager = manager
        currency_list.adapter = controller.adapter

        buy_button.setOnClickListener({
            checkInput()
        })
    }

    private fun checkInput() {
        if (controller.adapter.selectedCurrency != null && amount_to_buy.text.isNotEmpty()) {
            controller.buyCurrency(controller.adapter.selectedCurrency, amount_to_buy.text.toString())
        }else{
            toastMessage("Por favor ingrese moneda y monto a comprar")
        }
    }

    fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
