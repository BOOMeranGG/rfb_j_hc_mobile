package com.devian_orange.myapplication.model.dto

import com.devian_orange.myapplication.model.dto.enums.AccountType
import com.google.gson.annotations.SerializedName

class RegistrationDto {

    @SerializedName("login")
    var login: String = ""

    @SerializedName("password")
    var password: String = ""

    @SerializedName("accountType")
    lateinit var accountType: AccountType

    @SerializedName("fullname")
    var fullName: String = ""
}