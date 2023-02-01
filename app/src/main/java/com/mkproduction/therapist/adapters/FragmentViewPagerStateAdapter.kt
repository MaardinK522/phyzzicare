package com.mkproduction.therapist.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragmentViewPagerStateAdapter(
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {
    private var fragmentList: ArrayList<Fragment> = ArrayList()
    fun addFragment(vararg fragments: Fragment): FragmentViewPagerStateAdapter {
        for (fragment in fragments) fragmentList.add(fragment)
        return this
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragmentList[0]
            1 -> fragmentList[1]
            else -> {
                fragmentList[2]
            }
        }
    }
}