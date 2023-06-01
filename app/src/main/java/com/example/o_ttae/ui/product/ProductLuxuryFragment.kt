package com.example.o_ttae.ui.product

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.o_ttae.ui.product.price.ProductPriceVPAdapter
import com.example.o_ttae.R
import com.example.o_ttae.data.model.WeekProduct
import com.example.o_ttae.data.adapter.WeekProductRVAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList

class ProductLuxuryFragment : Fragment(),WeekProductRVAdapter.MyItemClickListener {

    private lateinit var productLuxuryWeekRv: RecyclerView
    private var weekProductData = ArrayList<WeekProduct>()

    private lateinit var productCategoryPriceTb: TabLayout
    lateinit var productCategoryPriceVp: ViewPager2
    private val productCategoryTab = arrayListOf("전체", "후원 및 기부", "일자리 창출", "취약계층 지원")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_product_category, container, false)

        productLuxuryWeekRv = view.findViewById(R.id.product_category_week_rv)
        productCategoryPriceTb = view.findViewById(R.id.product_category_price_tb)
        productCategoryPriceVp = view.findViewById(R.id.product_category_price_vp)

        // 가격대별 인기선물 TabLayout, ViewPager2 연결
        val productPriceFm = childFragmentManager
        val productPriceLifecycle = viewLifecycleOwner.lifecycle
        val productPriceVPAdapter =
            ProductPriceVPAdapter(productPriceFm, productPriceLifecycle)
        productCategoryPriceVp.adapter = productPriceVPAdapter

        TabLayoutMediator(productCategoryPriceTb, productCategoryPriceVp) { tab, position ->
            tab.text = productCategoryTab[position]
        }.attach()

        productCategoryPriceVp.isUserInputEnabled = false
        productCategoryPriceTb.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { productCategoryPriceVp.setCurrentItem(it, false) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


        // 금주의 이거 어때? 데이터 리스트
        weekProductData.apply {
            add(WeekProduct("스프링샤인", "짜욱작가의 사막여우 티셔츠", R.drawable.product_list_fox_img))
            add(WeekProduct("마마나스협동조합", "오가닉 천 유아슈트", R.drawable.product_list_kids_img))
            add(WeekProduct("페어트레이드코리아", "스퀘어 가디건 블랙", R.drawable.product_list_cardigan_img))
            add(WeekProduct("신호에이피엘", "특양면 오버핏 맨투맨", R.drawable.product_list_green_img))
        }

        // 어댑터와 데이터 리스트 연결
        val luxuryWeekProductRVAdapter = WeekProductRVAdapter(weekProductData)
        luxuryWeekProductRVAdapter.setMyItemClickListener(this)
        productLuxuryWeekRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )
        productLuxuryWeekRv.adapter = luxuryWeekProductRVAdapter

        return view
    }

    override fun onItemClick(weekProduct: WeekProduct) {
        val intent = Intent(requireContext(), ProductDetailActivity3::class.java)
        intent.putExtra("weekProduct", weekProduct)
        startActivity(intent)
    }
}