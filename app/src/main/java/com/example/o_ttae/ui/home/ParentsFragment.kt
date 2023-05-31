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

class ParentsFragment : Fragment() {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    lateinit var homeParentsProductRv1: RecyclerView
    lateinit var homeParentsProductRv2: RecyclerView
    lateinit var homeParentsAllBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_parents, container, false)

        homeParentsProductRv1 = view.findViewById(R.id.home_parents_product_rv1)
        homeParentsProductRv2 = view.findViewById(R.id.home_parents_product_rv2)
        homeParentsAllBtn = view.findViewById(R.id.home_parents_all_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        productData1.apply {
            add(Product("인사이디1", "휴대용 미니 마사지건 IMG-BP", "59,900", R.drawable.product_list_massage_gun_img))
            add(Product("한우맘", "1등급 한우 선물세트 1.2kg", "79,000", R.drawable.product_list_meat_img))
            add(Product("복순도가", "복순도가 손막걸리 935ml x 1병", "12,000", R.drawable.product_list_makgeolli_img))
            add(Product("이너셋", "더 진한 홍삼 100스틱 10g x 100포", "44,900", R.drawable.product_list_red_ginseng_img))
        }

        productData2.apply {
            add(Product("인사이디2", "휴대용 미니 마사지건 IMG-BP", "59,900", R.drawable.product_list_massage_gun_img))
            add(Product("한우맘", "1등급 한우 선물세트 1.2kg", "79,000", R.drawable.product_list_meat_img))
            add(Product("복순도가", "복순도가 손막걸리 935ml x 1병", "12,000", R.drawable.product_list_makgeolli_img))
            add(Product("이너셋", "더 진한 홍삼 100스틱 10g x 100포", "44,900", R.drawable.product_list_red_ginseng_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeParentsProductRVAdapter1 = ProductRVAdapter(productData1)
        homeParentsProductRv1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeParentsProductRv1.adapter = homeParentsProductRVAdapter1

        val homeParentsProductRVAdapter2 = ProductRVAdapter(productData2)
        homeParentsProductRv2.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        homeParentsProductRv2.adapter = homeParentsProductRVAdapter2

        // 전체 보기 버튼 클릭 시 상품 리스트 페이지로 이동
        homeParentsAllBtn.setOnClickListener {
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
