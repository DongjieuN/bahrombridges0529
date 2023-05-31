package com.example.o_ttae.ui.product.price

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.o_ttae.data.model.Product
import com.example.o_ttae.data.adapter.ProductRVAdapter
import com.example.o_ttae.R
import java.util.ArrayList

class PriceFiveFragment : Fragment() {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    private lateinit var priceFiveProductRv1: RecyclerView
    private lateinit var priceFiveProductRv2: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_price, container, false)

        priceFiveProductRv1 = view.findViewById(R.id.price_product_rv1)
        priceFiveProductRv2 = view.findViewById(R.id.price_product_rv2)

        productData1.apply {
            add(Product("모던포인트1", "원목 유선 플랜테리어 식물 무드등 LED", "55,000", R.drawable.product_list_mood_light_img))
            add(Product("러쉬", "더티 보디 스프레이 200ml", "60,000", R.drawable.product_list_lush_img))
            add(Product("말본골프", "Bucket 햇 WHITE", "99,000", R.drawable.product_list_hat_img))
            add(Product("Apple", "에어팟 프로 (맥세이프 충전 케이스)", "269,000", R.drawable.product_list_airpot_img))
        }

        productData2.apply {
            add(Product("모던포인트2", "원목 유선 플랜테리어 식물 무드등 LED", "55,000", R.drawable.product_list_mood_light_img))
            add(Product("러쉬", "더티 보디 스프레이 200ml", "60,000", R.drawable.product_list_lush_img))
            add(Product("말본골프", "Bucket 햇 WHITE", "99,000", R.drawable.product_list_hat_img))
            add(Product("Apple", "에어팟 프로 (맥세이프 충전 케이스)", "269,000", R.drawable.product_list_airpot_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceFiveProductRv1.layoutManager = LinearLayoutManager(context)
        priceFiveProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceFiveProductRv2.layoutManager = LinearLayoutManager(context)
        priceFiveProductRv2.adapter = priceProductRvAdapter2

        return view
    }
}
