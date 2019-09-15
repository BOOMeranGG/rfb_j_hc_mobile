package com.devian_orange.myapplication.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.dto.OrderDto
import com.devian_orange.myapplication.web.WebController
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_orders_history.*
import kotlinx.android.synthetic.main.list_item_order_history.view.*
import java.util.*

class OrdersHistoryActivity : BaseActivity(1), WebController.OrdersController {

    private var orders = listOf<OrderDto>(
//        OrderDto("MothersaSG@yandex.ru", "desciption", 125000),
//        OrderDto("MothersaSG@yandex.ru", "desciption2", 135000),
//        OrderDto("MothersaSG@yandex.ru", "desciption3", 225000),
//        OrderDto("MothersaSG@yandex.ru", "desciption4", 185000),
//        OrderDto("MothersaSG@yandex.ru", "desciption5", 525000),
//        OrderDto("MothersaSG@yandex.ru", "desciption6", 145000),
//        OrderDto("MothersaSG@yandex.ru", "desciption7", 995000),
//        OrderDto("MothersaSG@yandex.ru", "desciption8", 148800),
//        OrderDto("MothersaSG@yandex.ru", "desciption9", 133700),
//        OrderDto("MothersaSG@yandex.ru", "desciption0", 22832200)
    )
    private lateinit var orderRecyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private val webController = WebController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_history)

        close_image.setOnClickListener {
            finish()
        }

        setUpBottomNavigation()
        setUpRecycler()

        webController.getAllOrders(this)
    }

    private fun setUpRecycler() {
        orderAdapter = OrderAdapter(orders)
        orderRecyclerView = findViewById(R.id.container_recycler_orders)
        orderRecyclerView.layoutManager = GridLayoutManager(this, 2)
        orderRecyclerView.adapter = orderAdapter
    }

//    private fun dataSource(): Observable<List<OrderDto>> {
//        return Observable.just(webController.getAllOrders())
//    }

    private fun updateUi() {
        orderAdapter.setPortfolio(orders)
        orderAdapter.notifyDataSetChanged()
    }

    override fun onCompleteWaitingOrders(orders: List<OrderDto>) {
        this.orders = orders
        updateUi()
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
