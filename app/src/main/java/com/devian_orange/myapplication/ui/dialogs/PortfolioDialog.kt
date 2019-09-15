package com.devian_orange.myapplication.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.dialog_portfolio.*

class PortfolioDialog(private val imgId: Int, private val textInfo: String) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val v = LayoutInflater.from(activity).inflate(R.layout.dialog_portfolio, null)

        return AlertDialog.Builder(activity)
            .setView(v)
            .setTitle("Experience info")
            .setCancelable(true)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        src_main.setImageResource(imgId)
        tv_main_info.text = textInfo
    }
}