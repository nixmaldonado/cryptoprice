package com.globant.cryptoprice

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.globant.cryptoprice.quotation.Controller
import com.globant.cryptoprice.repository.PricesRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val LIST_ID = "listId"
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val repository = PricesRepository()
    private var viewModel = CurrenciesViewModel(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = Controller(this)
        controller.start()

        viewModel = ViewModelProviders.of(this).get(CurrenciesViewModel::class.java)
        viewModel.init()

        viewModel.getCurrentCurrencyList()?.observe(this, Observer {
            controller.recyclerAdapter.notifyDataSetChanged()
        })

        linearLayoutManager = LinearLayoutManager(this)
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


