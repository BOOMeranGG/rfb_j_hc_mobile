package com.devian_orange.myapplication.presenters

import android.content.Context

private const val FILE_SETTINGS_NAME = "settingsFileName"
private const val PERSON_SIGN_UP_KEY = "isSignUp"
const val IS_FREELANCER_KEY = "isFreelancer"

class RegistrationPresenter {

    fun isRegistered(context: Context?): Boolean {
        val preferences = context?.getSharedPreferences(FILE_SETTINGS_NAME, Context.MODE_PRIVATE)
        return preferences!!.getBoolean(PERSON_SIGN_UP_KEY, false)
    }

    fun checkValidEmail(email: String): Boolean {
        return true
    }

    fun signUp(context: Context?, email: String, password: String, isFreelancer: Boolean) {
        val settings = context?.getSharedPreferences(FILE_SETTINGS_NAME, Context.MODE_PRIVATE)
        val editor = settings?.edit()
        editor?.putBoolean(PERSON_SIGN_UP_KEY, true)
        editor?.putBoolean(IS_FREELANCER_KEY, isFreelancer)
        editor?.apply()
    }
}