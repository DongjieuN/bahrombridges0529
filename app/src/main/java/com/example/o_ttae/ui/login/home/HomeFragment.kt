package com.example.o_ttae.ui.login.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.o_ttae.ui.gift.GiftFragment
import com.example.o_ttae.ui.MainActivity
import com.example.o_ttae.R
import com.example.o_ttae.ui.taste.TasteFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList

class HomeFragment : Fragment() {

    lateinit var homeBannerVp: ViewPager2
    lateinit var homeBannerTb: TabLayout
    lateinit var homeCategoryTb: TabLayout
    lateinit var homeCategoryVp: ViewPager2
    lateinit var homeGiftBtn: Button
    lateinit var homeTasteBtn: Button

    var currentPosition = 0
    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true
    }

    private val homeCategoryTab = arrayListOf("식품", "생필품", "잡화", "의류")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        homeBannerVp = view.findViewById(R.id.home_banner_vp)
        homeBannerTb = view.findViewById(R.id.home_banner_tb)
        homeCategoryTb = view.findViewById(R.id.home_category_tb)
        homeCategoryVp = view.findViewById(R.id.home_category_vp)
        homeGiftBtn = view.findViewById(R.id.home_gift_btn)
        homeTasteBtn = view.findViewById(R.id.home_taste_btn)


        // 비밀선물 버튼 클릭 시 비밀선물 페이지로 이동
        homeGiftBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, GiftFragment()).commitAllowingStateLoss()
        }

        // 취향저격 선물 버튼 클릭 시 취향선물 페이지로 이동
        homeTasteBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TasteFragment()).commitAllowingStateLoss()
        }


        // Home 화면 상단 배너 - TabLayout, ViewPager2 연결
        val homeBannerFm = childFragmentManager
        val homeBannerLifecycle = viewLifecycleOwner.lifecycle
        val homeBannerAdapter = HomeBannerVPAdapter(homeBannerFm, homeBannerLifecycle)

        homeBannerVp.adapter = homeBannerAdapter
        homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(homeBannerTb, homeBannerVp) { tab, position ->
        }.attach()

        homeBannerAdapter.addFragment(
            HomeBannerFragment(
                R.drawable.home_banner_img1,
                "STORE 36.5",
                "오프라인으로 만나보는 사회적 기업!"
            )
        )
        homeBannerAdapter.addFragment(
            HomeBannerFragment(
                R.drawable.home_banner_img2,
                "아름다운 가게",
                "물건의 재사용과 순환을 통해 변화에 기여!"
            )
        )
        homeBannerAdapter.addFragment(
            HomeBannerFragment(
                R.drawable.home_banner_img3,
                "아름다운 가게 ",
                "사회의 생태적, 친환경적 변화에 기여!"
            )
        )

        // Home 화면 상단 배너 - ViewPager2 넘기는 Thread
        val thread = Thread(PagerRunnable())
        thread.start()


        // Home 화면 카테고리 - TabLayout, ViewPager2 연결
        val homeCategoryFm = childFragmentManager
        val homeCategoryLifecycle = viewLifecycleOwner.lifecycle
        val homeCategoryAdapter = HomeCategoryVPAdapter(homeCategoryFm, homeCategoryLifecycle)
        homeCategoryVp.adapter = homeCategoryAdapter

        TabLayoutMediator(homeCategoryTb, homeCategoryVp) { tab, position ->
            tab.text = homeCategoryTab[position]
        }.attach()

        homeCategoryVp.isUserInputEnabled = false
        homeCategoryTb.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { homeCategoryVp.setCurrentItem(it, false) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        return view
    }

    // Home 화면 상단 배너 - 페이지 변경
    fun setPage() {
        if (currentPosition == 2) currentPosition = 0
        homeBannerVp.setCurrentItem(currentPosition, true)
        currentPosition += 1
    }

    // Home 화면 상단 배너 - 2초마다 페이지 넘기기
    inner class PagerRunnable : Runnable {
        override fun run() {
            try {
                while (true) {
                    Thread.sleep(2000)
                    handler.sendEmptyMessage(0)
                }
            } catch (e: InterruptedException) {
                Log.d("Banner", "쓰레드가 죽었습니다. ${e.message}")
            }
        }
    }

    private inner class HomeBannerVPAdapter(
        childFragmentManager: FragmentManager,
        getLifecycle: Lifecycle
    ) :
        FragmentStateAdapter(childFragmentManager, getLifecycle) {

        private val fragmentList: ArrayList<Fragment> = ArrayList()

        override fun getItemCount(): Int = fragmentList.size

        override fun createFragment(position: Int): Fragment = fragmentList[position]

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
            notifyItemInserted(fragmentList.size - 1)
        }

    }
}