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

class CoupleFragment : Fragment() {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    lateinit var homeCoupleProductRv1: RecyclerView
    lateinit var homeCoupleProductRv2: RecyclerView
    lateinit var homeCoupleAllBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_birthday, container, false)

        homeCoupleProductRv1 = view.findViewById(R.id.home_birthday_product_rv1)
        homeCoupleProductRv2 = view.findViewById(R.id.home_birthday_product_rv2)
        homeCoupleAllBtn = view.findViewById(R.id.home_birthday_all_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        productData1.apply {
            add(Product("JW중외제약1", "피톤케어360 차량용 방향제", "42,000", R.drawable.product_list_air_freshener_img))
            add(Product("터틀힙", "Lettering 벚꽃크림 케이크", "59,000", R.drawable.product_list_cake_img))
            add(Product("DOOSI", "[생화] 피치살몬 꽃다발", "35,900", R.drawable.producst_list_flower_img))
            add(Product("하이미엘", "천연 꿀버터 뚱카롱(마카롱) 10구 선물패키지", "22,900", R.drawable.product_list_macaroon_img))
        }

        productData2.apply {
            add(Product("JW중외제약2", "피톤케어360 차량용 방향제", "42,000", R.drawable.product_list_air_freshener_img))
            add(Product("터틀힙", "Lettering 벚꽃크림 케이크", "59,000", R.drawable.product_list_cake_img))
            add(Product("DOOSI", "[생화] 피치살몬 꽃다발", "35,900", R.drawable.producst_list_flower_img))
            add(Product("하이미엘", "천연 꿀버터 뚱카롱(마카롱) 10구 선물패키지", "22,900", R.drawable.product_list_macaroon_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeCoupleProductRVAdapter1 = ProductRVAdapter(productData1)
        homeCoupleProductRv1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeCoupleProductRv1.adapter = homeCoupleProductRVAdapter1

        val homeCoupleProductRVAdapter2 = ProductRVAdapter(productData2)
        homeCoupleProductRv2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeCoupleProductRv2.adapter = homeCoupleProductRVAdapter2

        // 전체 보기 버튼 클릭 시 상품 리스트 페이지로 이동
        homeCoupleAllBtn.setOnClickListener {
            sendData(0)
            transaction.replace(R.id.main_frm, ProductFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

    // 이동할 카테고리 탭 전달
    private fun sendData(tabPosition: Int) {
        val pref = this.activity?.getPreferences(0)
        val editor = pref?.edit()

        editor?.putInt("tabPosition", tabPosition)?.apply()
    }
}
