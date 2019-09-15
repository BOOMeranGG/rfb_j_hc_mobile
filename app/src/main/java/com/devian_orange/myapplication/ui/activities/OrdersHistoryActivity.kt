package com.devian_orange.myapplication.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.OrderDto
import kotlinx.android.synthetic.main.activity_orders_history.*
import kotlinx.android.synthetic.main.list_item_order_history.view.*
import java.util.*

class OrdersHistoryActivity : BaseActivity(1) {

    private var orders = listOf(
        OrderDto("MothersaSG@yandex.ru", "desciption", 125000),
        OrderDto("MothersaSG@yandex.ru", "desciption2", 135000),
        OrderDto("MothersaSG@yandex.ru", "desciption3", 225000),
        OrderDto("MothersaSG@yandex.ru", "desciption4", 185000),
        OrderDto("MothersaSG@yandex.ru", "desciption5", 525000),
        OrderDto("MothersaSG@yandex.ru", "desciption6", 145000),
        OrderDto("MothersaSG@yandex.ru", "desciption7", 995000),
        OrderDto("MothersaSG@yandex.ru", "desciption8", 148800),
        OrderDto("MothersaSG@yandex.ru", "desciption9", 133700),
        OrderDto("MothersaSG@yandex.ru", "desciption0", 22832200)
    )
    private lateinit var orderRecyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_history)

        close_image.setOnClickListener {
            finish()
        }

        setUpBottomNavigation()
        setUpRecycler()
    }

    private fun setUpRecycler() {
        orderAdapter = OrderAdapter(orders)
        orderRecyclerView = findViewById(R.id.container_recycler_orders)
        orderRecyclerView.layoutManager = GridLayoutManager(this, 2)
        orderRecyclerView.adapter = orderAdapter
    }

    // ----------------------------------------------------------------------------

    private inner class OrderHolder(val portfolioView: View) : RecyclerView.ViewHolder(portfolioView) {

        @SuppressLint("SetTextI18n")
        fun bindPortfolio(order: OrderDto) {
            portfolioView.tv_login.text = order.login
            portfolioView.tv_description.text = order.description
            portfolioView.tv_money.text = "${(order.price / 100)} Рублей"
        }

        private fun setRandomImage(img: ImageView) {
            when (Random().nextInt(5) + 1) {
                1 -> img.setImageResource(R.drawable.freelancer1)
                2 -> img.setImageResource(R.drawable.freelancer2)
                3 -> img.setImageResource(R.drawable.freelancer3)
                4 -> img.setImageResource(R.drawable.freelancer4)
                5 -> img.setImageResource(R.drawable.freelancer5)
            }
        }
    }

    private inner class OrderAdapter(private var orders: List<OrderDto>) :
        RecyclerView.Adapter<OrderHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
            val layoutInflater = LayoutInflater.from(this@OrdersHistoryActivity)
            val view = layoutInflater.inflate(R.layout.list_item_order_history, parent, false)

            return OrderHolder(view)
        }

        override fun onBindViewHolder(holder: OrderHolder, position: Int) {
            val info = orders[position]
            holder.bindPortfolio(info)
        }

        override fun getItemCount(): Int = orders.size

        fun setPortfolio(portfolioList: List<OrderDto>) {
            this.orders = portfolioList
        }
    }
}
