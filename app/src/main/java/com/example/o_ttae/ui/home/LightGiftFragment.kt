package com.example.o_ttae.ui.home

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

class LightGiftFragment : Fragment() {

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
            add(Product("대봉식품1", "둘이 함께 먹는 매일견과 20g x 60봉", "25,430", R.drawable.product_list_nut_img))
            add(Product("경남제약", "카카오 레모나산 2g 100포", "17,450", R.drawable.product_list_lemona_img))
            add(Product("캐릭터주방", "돌아온 스누피 댄스댄스 글라스잔 2P세트", "17,850", R.drawable.product_list_glass_img))
            add(Product("원더커피", "더치커피 5종원두 혼합 100팩", "18,900", R.drawable.product_list_coffee_img))
        }

        productData2.apply {
            add(Product("대봉식품2", "둘이 함께 먹는 매일견과 20g x 60봉", "25,430", R.drawable.product_list_nut_img))
            add(Product("경남제약", "카카오 레모나산 2g 100포", "17,450", R.drawable.product_list_lemona_img))
            add(Product("캐릭터주방", "돌아온 스누피 댄스댄스 글라스잔 2P세트", "17,850", R.drawable.product_list_glass_img))
            add(Product("원더커피", "더치커피 5종원두 혼합 100팩", "18,900", R.drawable.product_list_coffee_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeLightGiftProductRVAdapter1 = ProductRVAdapter(productData1)
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

    // 이동할 카테고리 탭 전달
    private fun sendData(tabPosition: Int) {
        var pref = this.activity?.getPreferences(0)
        var editor = pref?.edit()

        editor?.putInt("tabPosition", tabPosition)?.apply()
    }
}
