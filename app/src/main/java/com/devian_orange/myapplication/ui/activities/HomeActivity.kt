package com.devian_orange.myapplication.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.list_item_portfolio.view.*
import java.util.*

class HomeActivity : BaseActivity(0) {

    private var portfolioList = listOf(
        "Здесь должна быть информация из вашего портфолио",
        "Roundtable Rival - Lindsey Stirling",
        "Миша, плиз, придумай описание",
        "FUCK YOU LEATHER MAN",
        "И сново десь должна быть информация из вашего портфолио",
        "Who call the dragon knight?",
        "Orange infinity is the best team",
        "Go Go PowerRangers",
        "Здесь должна быть информация из вашего портфолио",
        "Orange infinity FOREVER"
    )

    private lateinit var portfolioRecyclerView: RecyclerView
    private lateinit var portfolioAdapter: PortfolioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpBottomNavigation()
        setUpRecycler()

        close_image.setOnClickListener {
            System.exit(0)
        }
    }

    private fun setUpRecycler() {
        portfolioAdapter = PortfolioAdapter(portfolioList)
        portfolioRecyclerView = findViewById(R.id.container_recycler_portfolio)
        portfolioRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        portfolioRecyclerView.adapter = portfolioAdapter
    }

    private fun updateUi() {
        portfolioAdapter.setPortfolio(portfolioList)
        portfolioAdapter.notifyDataSetChanged()
    }

    // ----------------------------------------------------------------------------

    private inner class PortfolioHolder(val portfolioView: View) : RecyclerView.ViewHolder(portfolioView) {

        fun bindPortfolio(info: String) {
            if (adapterPosition != 0) {
                portfolioView.profile_info.visibility = View.GONE
            }
            portfolioView.tv_info.text = info
            setRandomImage(portfolioView.img_preview)
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

    private inner class PortfolioAdapter(private var portfolioList: List<String>) :
        RecyclerView.Adapter<PortfolioHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioHolder {
            val layoutInflater = LayoutInflater.from(this@HomeActivity)
            val view = layoutInflater.inflate(R.layout.list_item_portfolio, parent, false)

            return PortfolioHolder(view)
        }

        override fun onBindViewHolder(holder: PortfolioHolder, position: Int) {
            val info = portfolioList[position]
            holder.bindPortfolio(info)
        }

        override fun getItemCount(): Int = portfolioList.size

        fun setPortfolio(portfolioList: List<String>) {
            this.portfolioList = portfolioList
        }
    }
}
