package com.globant.cryptoprice

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.globant.cryptoprice.quotation.QuotationFragment
import com.globant.cryptoprice.transaction.TransactionFragment
import com.globant.cryptoprice.wallet.WalletFragment

class FragmentManager(fm: android.support.v4.app.FragmentManager) : FragmentPagerAdapter(fm) {

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
}
