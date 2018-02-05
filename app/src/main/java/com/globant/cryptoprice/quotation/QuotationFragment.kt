package com.globant.cryptoprice.quotation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globant.cryptoprice.R
import kotlinx.android.synthetic.main.fragment_quotation.*

class QuotationFragment : Fragment() {

    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_quotation, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = QuotationController(this)
        controller.start()

        layoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = controller.adapter
    }

    fun hideProgressBar() {
        progress_bar?.visibility = View.GONE
    }
}

