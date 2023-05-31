package com.example.o_ttae.ui.product

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProductCategoryVPAdapter(childFragmentManager: FragmentManager, getLifecycle: Lifecycle) :
    FragmentStateAdapter(childFragmentManager, getLifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProductBirthdayFragment()     // 식품 카테고리
            1 -> ProductParentsFragment()      // 생필품 카테고리
            2 -> ProductLightGiftFragment()    // 잡화 선물 카테고리
            else -> ProductLuxuryFragment()       // 의류 카테고리
        }
    }
}