package com.devian_orange.myapplication.model

class CustomerDto(
    val login: String,
    val name: String,
    val sumOfRating: Int,
    val numberOfRating: Int,
    val feedBackList: List<FeedbackDto>,
    val portfolios: List<String>
)