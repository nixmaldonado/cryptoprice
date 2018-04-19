package com.nuklas.cryptoprice

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.nuklas.cryptoprice.quotation.QuotationFragment
import com.nuklas.cryptoprice.transaction.TransactionFragment
import com.nuklas.cryptoprice.wallet.WalletFragment

class FragmentManager(fm: android.support.v4.app.FragmentManager) : FragmentPagerAdapter(fm) {

    private val tittles = arrayListOf("Precios", "Billetera", "Balance")

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 ->
                return QuotationFragment()
            1 ->
                return WalletFragment()
            2 ->
                return TransactionFragment()
        }
        return null
    }


    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tittles[position]
    }
}
