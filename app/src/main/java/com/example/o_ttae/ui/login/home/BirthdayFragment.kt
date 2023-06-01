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
import com.example.o_ttae.ui.product.price.ProductDetailActivity6
import java.util.*

class BirthdayFragment : Fragment(), ProductRVAdapter.MyItemClickListener {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    lateinit var homeBirthdayProductRv1: RecyclerView
    lateinit var homeBirthdayProductRv2: RecyclerView
    lateinit var homeBirthdayAllBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_birthday, container, false)

        homeBirthdayProductRv1 = view.findViewById(R.id.home_birthday_product_rv1)
        homeBirthdayProductRv2 = view.findViewById(R.id.home_birthday_product_rv2)
        homeBirthdayAllBtn = view.findViewById(R.id.home_birthday_all_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        productData1.apply {
            add(Product("동그라미플러스", "맛있는 육포야", "8,200", R.drawable.product_list_yukpo_img))
            add(Product("그라나다보호작업센터", "밸런스브라운", "16,000", R.drawable.product_list_bean_img))
            add(Product("누리봄사회적협동조합", "도담잡곡 누룽지", "6,000", R.drawable.product_list_nulungzi_img))
            add(Product("비컴프렌즈", "Obong miel 꿀스틱", "13,000", R.drawable.product_list_honey_img))
        }

        productData2.apply {
            add(Product("트립티", "트립티 원두 티백", "6,000", R.drawable.product_list_tee_img))
            add(Product("두리하나다울", "쿠키선물바구니(중)", "50,000", R.drawable.product_list_cookie_img))
            add(Product("아시아공정무역네트워크", "페어데이 공정무역 생캐슈넛(250g)", "9,000", R.drawable.product_list_nuts_img))
            add(Product("사랑의 일터", "미니쿠키 3종세트", "15,000", R.drawable.product_list_mini_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeBirthdayProductRVAdapter1 = ProductRVAdapter(productData1)
        homeBirthdayProductRVAdapter1.setMyItemClickListener(this)
        homeBirthdayProductRv1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeBirthdayProductRv1.adapter = homeBirthdayProductRVAdapter1

        val homeBirthdayProductRVAdapter2 = ProductRVAdapter(productData2)
        homeBirthdayProductRv2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeBirthdayProductRv2.adapter = homeBirthdayProductRVAdapter2

        // 전체 보기 버튼 클릭 시 상품 리스트 페이지로 이동
        homeBirthdayAllBtn.setOnClickListener {
            sendData(0)
            transaction.replace(R.id.main_frm, ProductFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity9::class.java)
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

