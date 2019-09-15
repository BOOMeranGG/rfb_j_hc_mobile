package com.devian_orange.myapplication.ui.activities

import android.os.Bundle
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.model.CustomerDto
import com.devian_orange.myapplication.model.FeedbackDto

class SearchActivity : BaseActivity(2) {

    private val testFeedbackList = listOf(FeedbackDto("Review", 5, "login"))
    private val testCustomers = listOf(
        CustomerDto("login1", "name1", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login2", "name2", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login3", "name3", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login4", "name4", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login5", "name5", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login6", "name6", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login7", "name7", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login8", "name8", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login9", "name9", 5, 1, testFeedbackList, listOf("GOOD ONE")),
        CustomerDto("login0", "name0", 5, 1, testFeedbackList, listOf("GOOD ONE"))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setUpBottomNavigation()
    }
}
