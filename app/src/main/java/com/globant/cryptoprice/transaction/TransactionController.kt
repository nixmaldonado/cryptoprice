package com.globant.cryptoprice.transaction

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import kotlinx.android.synthetic.main.fragment_transaction.*
import java.text.NumberFormat


class TransactionController(private val fragment: TransactionFragment) : View.OnClickListener {

    private val amountKey = "FIAT_AMOUT"
    private lateinit var sharedPreferences: SharedPreferences
    private val formatter = NumberFormat.getCurrencyInstance()

    fun start() {
        sharedPreferences = fragment.activity.getPreferences(Context.MODE_PRIVATE)

        val currentFiatAmount = sharedPreferences.getString(amountKey, "0")
        fragment.fiat_balance.text = formatter.format(currentFiatAmount.toDouble())

        fragment.add_money_button.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        val amountToAdd = fragment.amount_to_add.text.toString()

        fragment.fiat_balance.text = formatter.format(amountToAdd.toDouble())
        sharedPreferences.edit().putString(amountKey, amountToAdd).apply()
    }


}