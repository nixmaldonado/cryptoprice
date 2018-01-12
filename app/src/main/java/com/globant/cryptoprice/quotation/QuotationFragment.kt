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

    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_quotation, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Controller(this)
        controller.start()

        linearLayoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = controller.recyclerAdapter
    }

    fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }
}

