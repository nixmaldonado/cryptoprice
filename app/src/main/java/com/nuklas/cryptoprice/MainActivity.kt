package com.nuklas.cryptoprice

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import com.nuklas.cryptoprice.utils.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = FragmentManager(supportFragmentManager)
        viewPager = pager
        viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        tabs.setupWithViewPager(viewPager)

        viewPager.adapter = fragmentManager
    }
}


