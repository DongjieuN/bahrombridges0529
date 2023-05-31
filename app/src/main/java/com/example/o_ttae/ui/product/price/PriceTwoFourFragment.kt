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

class PriceTwoFourFragment : Fragment() {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    private lateinit var priceTwoFourProductRv1: RecyclerView
    private lateinit var priceTwoFourProductRv2: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_price, container, false)

        priceTwoFourProductRv1 = view.findViewById(R.id.price_product_rv1)
        priceTwoFourProductRv2 = view.findViewById(R.id.price_product_rv2)

        productData1.apply {
            add(Product("양키캔들1", "우드윅 미니 캔들 + 루나 스몰 캔들워머 + 전구 2개", "29,900", R.drawable.product_list_candle_img))
            add(Product("코튼랩", "수건선물세트 40수 8매", "44,000", R.drawable.product_list_towel_img))
            add(Product("에이치앤프렌즈", "\"오둥이 입니다만\" 오둥이 모찌 바디필로우", "29,800", R.drawable.product_list_pillow_img))
            add(Product("베리베리", "수제과일청 선물세트 (레몬청 + 자몽청)", "30,300", R.drawable.product_list_fruit_syrup_img))
        }

        productData2.apply {
            add(Product("양키캔들2", "우드윅 미니 캔들 + 루나 스몰 캔들워머 + 전구 2개", "29,900", R.drawable.product_list_candle_img))
            add(Product("코튼랩", "수건선물세트 40수 8매", "44,000", R.drawable.product_list_towel_img))
            add(Product("에이치앤프렌즈", "\"오둥이 입니다만\" 오둥이 모찌 바디필로우", "29,800", R.drawable.product_list_pillow_img))
            add(Product("베리베리", "수제과일청 선물세트 (레몬청 + 자몽청)", "30,300", R.drawable.product_list_fruit_syrup_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceTwoFourProductRv1.layoutManager = LinearLayoutManager(context)
        priceTwoFourProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceTwoFourProductRv2.layoutManager = LinearLayoutManager(context)
        priceTwoFourProductRv2.adapter = priceProductRvAdapter2

        return view
    }
}