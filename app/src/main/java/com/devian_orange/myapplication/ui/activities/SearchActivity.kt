package com.devian_orange.myapplication.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.dto.CustomerDto
import com.devian_orange.myapplication.model.dto.FeedbackDto
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.close_image
import kotlinx.android.synthetic.main.list_item_portfolio.*
import kotlinx.android.synthetic.main.list_item_portfolio.view.*
import java.util.*

class SearchActivity : BaseActivity(2) {

    private var currentIndex = 1
    private val testFeedbackList = listOf(FeedbackDto("Review", 5, "login"))
    private var portfolioList = listOf(
        "Здесь должна быть информация из вашего портфолио",
        "Roundtable Rival - Lindsey Stirling",
        "МИША, плиз, придумай описание",
        "FUCK YOU LEATHER MAN",
        "И сново десь должна быть информация из вашего портфолио",
        "Who call the dragon knight?",
        "Orange infinity is the best team",
        "Go Go PowerRangers",
        "Здесь должна быть информация из вашего портфолио",
        "Orange infinity FOREVER"
    )

    private var portfolioList2 = listOf(
        "Победитель Java Hack",
        "Работал 2 года в Райфайзен банке"
    )

    private var portfolioList3 = listOf(
        "Хет трик в финале турнира кожаный мяч",
        "drop table",
        "Миссклик"
    )

    private var photos = listOf(
        R.drawable.bill,
        R.drawable.ilon,
        R.drawable.freelancer5
    )


    private var currentList: List<String> = portfolioList
    private var mainList: List<List<String>> = listOf(portfolioList, portfolioList2, portfolioList3)

    private lateinit var portfolioRecyclerView: RecyclerView
    private lateinit var portfolioAdapter: PortfolioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setUpBottomNavigation()
        setUpRecycler()
        bindCard()

        close_image.setOnClickListener {
            finish()
        }
        motionLayout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenPass -> {
                        swipe()
                        controlPass()
                    }
                    R.id.offScreenLike -> {
                        swipe()
                        controlLike()
                    }
                }
            }
        })
    }

    private fun setUpRecycler() {
        portfolioAdapter = PortfolioAdapter(portfolioList)
        portfolioRecyclerView = findViewById(R.id.container_recycler_portfolio_search)
        portfolioRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        portfolioRecyclerView.adapter = portfolioAdapter
    }

    private fun updateUi() {
        portfolioAdapter.setPortfolio(currentList)
        portfolioAdapter.notifyDataSetChanged()
    }

    private fun controlPass() {
        Log.d("TAG228", "controlPass")
    }

    private fun controlLike() {
        Log.d("TAG228", "controlLike")
    }

    //TODO("Подгружать следующий аккаунт и выводить данные по нему")
    private fun bindCard() {
        //val top = testCustomers[currentIndex % testCustomers.size]
        //val bot = testCustomers[(currentIndex + 1) % testCustomers.size]

        //tv_top.text = top.login
        //tv_bottom.text = bot.login
        val newList = mainList[currentIndex % mainList.size]
        currentList = newList
    }

    private fun swipe() {
        motionLayout.progress = 0f
        motionLayout.setTransition(R.id.rest, R.id.like)
        currentIndex++

        portfolioList.forEach {
            it.reversed()
        }
        updateUi()
        bindCard()
        profile_image.setImageResource(photos[currentIndex % mainList.size])
    }

    // ----------------------------------------------------------------------------

    private inner class PortfolioHolder(val portfolioView: View) : RecyclerView.ViewHolder(portfolioView) {

        fun bindPortfolio(info: String) {
            if (adapterPosition != 0) {
                portfolioView.profile_info.visibility = View.GONE
            } else {
                portfolioView.profile_info.visibility = View.VISIBLE
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
            val layoutInflater = LayoutInflater.from(this@SearchActivity)
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
