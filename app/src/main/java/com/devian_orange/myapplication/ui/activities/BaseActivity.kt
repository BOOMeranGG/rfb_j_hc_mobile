package com.devian_orange.myapplication.ui.activities

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.devian_orange.myapplication.R
import kotlinx.android.synthetic.main.bottom_navigation_view.*

private const val TAG = "BaseActivity"

abstract class BaseActivity(private val navNumber: Int) : AppCompatActivity() {

    fun setUpBottomNavigation() {
        bottom_navigation_view.setIconSize(29f, 29f)
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.isItemHorizontalTranslationEnabled = false
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)

        for (i in 0 until bottom_navigation_view.menu.size()) {
            bottom_navigation_view.setIconTintList(i, null)
        }

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity = when (it.itemId) {
                R.id.item_profile -> HomeActivity::class.java
                R.id.item_history -> OrdersHistoryActivity::class.java
                R.id.item_share -> SearchActivity::class.java
                R.id.item_add_order -> AddOrderActivity::class.java
                else -> {
                    Log.e(TAG, "Unknown nav item clicked $it")
                    null
                }
            }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0, 0)
                true
            } else {
                false
            }
        }
        bottom_navigation_view.menu.getItem(navNumber).isChecked = true
    }
}