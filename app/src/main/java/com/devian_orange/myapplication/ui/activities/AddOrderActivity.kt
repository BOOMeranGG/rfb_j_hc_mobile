package com.devian_orange.myapplication.ui.activities

import android.os.Bundle
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.OrderDto
import com.devian_orange.myapplication.presenters.RegistrationPresenter
import kotlinx.android.synthetic.main.activity_add_order.*
import kotlinx.android.synthetic.main.activity_add_order.close_image
import kotlinx.android.synthetic.main.activity_home.*

class AddOrderActivity : BaseActivity(3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_order)

        setUpBottomNavigation()

        close_image.setOnClickListener {
            finish()
        }
        btn_confirm.setOnClickListener {
            createOrder()
        }
    }

    private fun createOrder() {
        val login = RegistrationPresenter().getEmail(this)
        val price = price_input.text.toString().toInt()
        val description = description_input.text.toString()

        val order = OrderDto(login, description, price)
    }
}
