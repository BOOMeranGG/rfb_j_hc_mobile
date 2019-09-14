package com.devian_orange.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.bottom_navigation_view.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation_view!!.setTextVisibility(false)
        bottom_navigation_view!!.enableItemShiftingMode(false)
        bottom_navigation_view!!.enableShiftingMode(false)
        bottom_navigation_view!!.enableAnimation(false)
    }
}
