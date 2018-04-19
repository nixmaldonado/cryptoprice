package com.nuklas.cryptoprice.transaction

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nuklas.cryptoprice.R

class TransactionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = TransactionController(this)
        controller.start()
    }
}
