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

class BirthdayFragment : Fragment() {

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
            add(Product("라이프 아카이브1", "라이프 아카이브 일회용 카메라", "20,120", R.drawable.product_list_film_img))
            add(Product("코지테이블", "아이보리앤도트 머그잔", "8,400", R.drawable.product_list_cup_img))
            add(Product("언폴드", "Copenhagen-bule 에코백", "9,800", R.drawable.product_list_bag_img))
            add(Product("비비디", "드레스 퍼퓸 100ml", "8,950", R.drawable.product_list_perfume_img))
        }

        productData2.apply {
            add(Product("라이프 아카이브2", "라이프 아카이브 일회용 카메라", "20,120", R.drawable.product_list_film_img))
            add(Product("코지테이블", "아이보리앤도트 머그잔", "8,400", R.drawable.product_list_cup_img))
            add(Product("언폴드", "Copenhagen-bule 에코백", "9,800", R.drawable.product_list_bag_img))
            add(Product("비비디", "드레스 퍼퓸 100ml", "8,950", R.drawable.product_list_perfume_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeBirthdayProductRVAdapter1 = ProductRVAdapter(productData1)
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

    // 이동할 카테고리 탭 전달
    private fun sendData(tabPosition: Int) {
        var pref = this.activity?.getPreferences(0)
        var editor = pref?.edit()

        editor?.putInt("tabPosition", tabPosition)?.apply()
    }
}

