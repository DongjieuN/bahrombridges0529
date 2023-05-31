package com.example.o_ttae.ui.login.home

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
            add(Product("스프링샤인", "짜욱작가의 사막여우 티셔츠", "23,000", R.drawable.product_list_fox_img))
            add(Product("소이프", "1919 유관순 티셔츠", "28,000", R.drawable.product_list_1919_img))
            add(Product("마마나스협동조합", "오가닉 천 유아슈트", "30,000", R.drawable.product_list_kids_img))
            add(Product("소이프", "홀마핸 티셔츠 화이트", "28,000", R.drawable.product_list_white_img))
        }

        productData2.apply {
            add(Product("페어트레이드코리아", "스퀘어 가디건 블랙", "96,600", R.drawable.product_list_cardigan_img))
            add(Product("신호에이피엘", "특양면 오버핏 맨투맨", "22,000", R.drawable.product_list_green_img))
            add(Product("다올협동조합", "올바른 순면 파자마 바지 남성/여성/커플", "19,900", R.drawable.product_list_pazamas_img))
            add(Product("마마나스협동조합", "오가닉 천 파자마", "30,000", R.drawable.product_list_pants_img))
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
