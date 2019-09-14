package com.devian_orange.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devian_orange.myapplication.R
import com.devian_orange.myapplication.presenters.RegistrationPresenter
import com.devian_orange.myapplication.ui.fragments.EmailFragment
import com.devian_orange.myapplication.ui.fragments.NamePassFragment
import com.devian_orange.myapplication.utils.showToast

class RegistrationActivity : AppCompatActivity(), EmailFragment.Listener, NamePassFragment.Listener {

    private lateinit var email: String
    //private var isFreelancer: Boolean = false
    private val registrationPresenter = RegistrationPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val isRegister = registrationPresenter.isRegistered(this)
        if (!isRegister && savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.register_container, EmailFragment())
                .commit()
        } else if (isRegister) {
            goToHomeActivity()
        }
    }

    override fun onNext(email: String) {
        this.email = email
        if (registrationPresenter.checkValidEmail(email)) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.register_container, NamePassFragment())
                .addToBackStack(null)
                .commit()
        } else {
            showToast(this, "Not a valid email ;(")
        }
    }

    override fun onRegister(password: String, isFreelancer: Boolean) {
        registrationPresenter.signUp(this, email, password, isFreelancer)
        goToHomeActivity()
    }

    private fun goToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}


