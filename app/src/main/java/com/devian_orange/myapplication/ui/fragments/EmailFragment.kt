package com.devian_orange.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.fragment_register_email.*

class EmailFragment : Fragment() {

    private lateinit var listener: Listener

    interface Listener {

        fun onNext(email: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_button.setOnClickListener {
            val email = email_input.text.toString()
            listener.onNext(email)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }
}