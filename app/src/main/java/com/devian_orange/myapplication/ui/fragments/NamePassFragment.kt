package com.devian_orange.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.fragment_register_namepass.*

class NamePassFragment : Fragment() {

    private lateinit var listener: Listener

    interface Listener {

        fun onRegister(password: String, isFreelancer: Boolean)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_namepass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        radio_freelancer.isChecked = true
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Listener
    }

    private fun setListeners() {
        tv_freelancer.setOnClickListener {
            radio_freelancer.isChecked = !radio_freelancer.isChecked
            radio_customer.isChecked = false
        }
        tv_customer.setOnClickListener {
            radio_customer.isChecked = !radio_customer.isChecked
            radio_freelancer.isChecked = false
        }
        radio_freelancer.setOnClickListener {
            radio_customer.isChecked = false
        }
        radio_customer.setOnClickListener {
            radio_freelancer.isChecked = false
        }

        register_button.setOnClickListener {
            val password = password_input.text.toString()
            listener.onRegister(password, radio_freelancer.isChecked)
        }
    }
}