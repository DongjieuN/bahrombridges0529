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
import com.example.o_ttae.data.model.Product
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList

class ProductBirthdayFragment : Fragment(), WeekProductRVAdapter.MyItemClickListener {

    private lateinit var productBirthdayWeekRv: RecyclerView
    private var weekProductData = ArrayList<WeekProduct>()

    private lateinit var productCategoryPriceTb: TabLayout
    lateinit var productCategoryPriceVp: ViewPager2
    private val productCategoryTab = arrayListOf("전체", "후원 및 기부", "일자리 창출", "취약계층 지원")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_product_category, container, false)


        productBirthdayWeekRv = view.findViewById(R.id.product_category_week_rv)
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
            add(WeekProduct("동그라미플러스", "맛있는 육포야", R.drawable.product_list_yukpo_img))
            add(WeekProduct("그라나다보호작업센터", "밸런스브라운", R.drawable.product_list_bean_img))
            add(WeekProduct("사랑의 일터", "미니쿠키 3종세트", R.drawable.product_list_mini_img))
            add(WeekProduct("트립티", "트립티 원두 티백", R.drawable.product_list_tee_img))
        }

        // 어댑터와 데이터 리스트 연결
        val birthdayWeekProductRVAdapter = WeekProductRVAdapter(weekProductData)
        birthdayWeekProductRVAdapter.setMyItemClickListener(this)

        productBirthdayWeekRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )
        productBirthdayWeekRv.adapter = birthdayWeekProductRVAdapter

        return view
    }

    override fun onItemClick(weekProduct: WeekProduct) {
        val intent = Intent(requireContext(), ProductDetailActivity::class.java)
        intent.putExtra("weekProduct", weekProduct)
        startActivity(intent)
    }


}