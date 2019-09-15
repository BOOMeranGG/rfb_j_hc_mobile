package com.devian_orange.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.activity_add_portfolio.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.close_image

class AddPortfolioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portfolio)

        close_image.setOnClickListener {
            finish()
        }

        btn_confirm.setOnClickListener {
            val description = description_input.text.toString()
            finish()
        }
    }
}
