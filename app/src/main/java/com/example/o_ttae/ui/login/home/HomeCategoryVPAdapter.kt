package com.example.o_ttae.ui.login.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeCategoryVPAdapter(childFragmentManager: FragmentManager, getLifecycle: Lifecycle) :
    FragmentStateAdapter(childFragmentManager, getLifecycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BirthdayFragment()    // 식품 카테고리
            1 -> ParentsFragment()     // 생필품 카테고리
            2 -> LightGiftFragment()   // 잡화 카테고리
            else -> LuxuryFragment()      // 의류 카테고리
        }
    }
}