package com.example.o_ttae.ui.login.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.o_ttae.*
import com.example.o_ttae.data.adapter.ProductRVAdapter
import com.example.o_ttae.data.model.Product
import com.example.o_ttae.ui.MainActivity
import com.example.o_ttae.ui.product.ProductFragment
import java.util.*

class LightGiftFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    lateinit var homeLightGiftProductRv1: RecyclerView
    lateinit var homeLightGiftProductRv2: RecyclerView
    lateinit var homeLightGiftAllBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_light_gift, container, false)

        homeLightGiftProductRv1 = view.findViewById(R.id.home_lightgift_product_rv1)
        homeLightGiftProductRv2 = view.findViewById(R.id.home_lightgift_product_rv2)
        homeLightGiftAllBtn = view.findViewById(R.id.home_lightgift_all_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        productData1.apply {
            add(Product("소이프", "버키버킷햇", "32,000", R.drawable.product_list_bucket_img))
            add(Product("목화송이협동조합", "20 BOTTLES 워킹백", "12,000", R.drawable.product_list_20_img))
            add(Product("마인드 디자인", "생각하는 구슬 여자용", "20,000", R.drawable.product_list_biz_img))
            add(Product("목화송이협동조합", "가벼운 방수앞치마", "22,000", R.drawable.product_list_apron_img))
        }

        productData2.apply {
            add(Product("하이사이클", "커피자루 필통 케이스", "12,000", R.drawable.product_list_case_img))
            add(Product("페어트레이드 코리아", "덤블링 미니 크로스백", "24,000", R.drawable.product_list_cross_img))
            add(Product("소이프", "나무늘보 그립톡", "12,000", R.drawable.product_list_sloth_img))
            add(Product("오피스메카", "컬러 에코백", "견적요청", R.drawable.product_list_color_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeLightGiftProductRVAdapter1 = ProductRVAdapter(productData1)
        homeLightGiftProductRVAdapter1.setMyItemClickListener(this)
        homeLightGiftProductRv1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeLightGiftProductRv1.adapter = homeLightGiftProductRVAdapter1

        val homeLightGiftProductRVAdapter2 = ProductRVAdapter(productData2)
        homeLightGiftProductRv2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeLightGiftProductRv2.adapter = homeLightGiftProductRVAdapter2

        // 전체 보기 버튼 클릭 시 상품 리스트 페이지로 이동
        homeLightGiftAllBtn.setOnClickListener {
            sendData(0)
            transaction.replace(R.id.main_frm, ProductFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity10::class.java)
        intent.putExtra("Product",Product)
        startActivity(intent)
    }

    // 이동할 카테고리 탭 전달
    private fun sendData(tabPosition: Int) {
        var pref = this.activity?.getPreferences(0)
        var editor = pref?.edit()

        editor?.putInt("tabPosition", tabPosition)?.apply()
    }
}
