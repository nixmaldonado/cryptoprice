package com.nuklas.cryptoprice.wallet

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nuklas.cryptoprice.buycurrency.BuyCurrencyActivity
import com.nuklas.cryptoprice.R
import kotlinx.android.synthetic.main.fragment_wallet.*

class WalletFragment : Fragment() {

    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = WalletController(this)
        controller.start()

        layoutManager = LinearLayoutManager(activity)
        wallet_recycler.layoutManager = layoutManager
        wallet_recycler.adapter = controller.adapter

        wallet_fab.setOnClickListener({
            val intent = Intent(activity, BuyCurrencyActivity::class.java)
            startActivity(intent)
        })
    }
}
