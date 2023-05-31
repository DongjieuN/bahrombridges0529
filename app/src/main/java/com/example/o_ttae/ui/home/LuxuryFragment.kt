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

class LuxuryFragment : Fragment() {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    lateinit var homeLuxuryProductRv1: RecyclerView
    lateinit var homeLuxuryProductRv2: RecyclerView
    lateinit var homeLuxuryAllBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_luxury, container, false)

        homeLuxuryProductRv1 = view.findViewById(R.id.home_luxury_product_rv1)
        homeLuxuryProductRv2 = view.findViewById(R.id.home_luxury_product_rv2)
        homeLuxuryAllBtn = view.findViewById(R.id.home_luxury_all_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        productData1.apply {
            add(Product("DIOR1", "[각인/선물포장] 립 글로우", "47,000", R.drawable.all_look_btn_shape))
            add(Product("젠틀몬스터", "릭 01", "259,000", R.drawable.all_look_btn_shape))
            add(Product("판도라", "신탄생석 참 목걸이세트", "98,000", R.drawable.all_look_btn_shape))
            add(Product("샤넬", "블루 드 샤넬 오 드 빠르펭 50ml", "127,000", R.drawable.all_look_btn_shape))
        }

        productData2.apply {
            add(Product("DIOR2", "[각인/선물포장] 립 글로우", "47,000", R.drawable.all_look_btn_shape))
            add(Product("젠틀몬스터", "릭 01", "259,000", R.drawable.all_look_btn_shape))
            add(Product("판도라", "신탄생석 참 목걸이세트", "98,000", R.drawable.all_look_btn_shape))
            add(Product("샤넬", "블루 드 샤넬 오 드 빠르펭 50ml", "127,000", R.drawable.all_look_btn_shape))
        }
        // 어댑터와 데이터 리스트 연결
        val homeLuxuryProductRVAdapter1 = ProductRVAdapter(productData1)
        homeLuxuryProductRv1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeLuxuryProductRv1.adapter = homeLuxuryProductRVAdapter1

        val homeLuxuryProductRVAdapter2 = ProductRVAdapter(productData2)
        homeLuxuryProductRv2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeLuxuryProductRv2.adapter = homeLuxuryProductRVAdapter2

        // 전체 보기 버튼 클릭 시 상품 리스트 페이지로 이동
        homeLuxuryAllBtn.setOnClickListener {
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
