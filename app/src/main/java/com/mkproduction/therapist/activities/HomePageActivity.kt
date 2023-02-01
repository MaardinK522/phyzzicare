package com.mkproduction.therapist.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mkproduction.therapist.R
import com.mkproduction.therapist.adapters.FragmentViewPagerStateAdapter
import com.mkproduction.therapist.fragments.HomeFragment
import com.mkproduction.therapist.fragments.PaymentFragment
import com.mkproduction.therapist.fragments.ProfileFragment

class HomePageActivity : AppCompatActivity() {
    private lateinit var mBottomNavigationBar: BottomNavigationView
    private lateinit var mFragmentViewPager2: ViewPager2
    private var doublePressed = false
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (doublePressed) {
                finish()
                return
            }
            doublePressed = true
            Toast.makeText(this@HomePageActivity, "Press again to back", Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed({
                doublePressed = false
            }, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
        // initializing all views
        findViews()
        // disables the slide from viewpager2 view
        mFragmentViewPager2.isUserInputEnabled = false
        mFragmentViewPager2.adapter = FragmentViewPagerStateAdapter(
            this@HomePageActivity
        ).addFragment(HomeFragment(), PaymentFragment(), ProfileFragment())
        mBottomNavigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_bar_home_item -> mFragmentViewPager2.currentItem = 0
                R.id.navigation_bar_payment_item -> mFragmentViewPager2.currentItem = 1
                R.id.navigation_bar_profile_item -> mFragmentViewPager2.currentItem = 2
            }
            true
        }
    }

    private fun findViews() {
        mBottomNavigationBar = findViewById(R.id.home_activity_bottom_navigation_bar)
        mFragmentViewPager2 = findViewById(R.id.home_activity_fragment_view_pager2)
    }
}
