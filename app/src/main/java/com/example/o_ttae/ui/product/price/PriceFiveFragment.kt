package com.example.o_ttae.ui.product.price // 취약계층 지원

import android.content.Intent
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

class PriceFiveFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

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
            add(Product("마마나스협동조합", "오가닉 천 파자마", "비혼모 지원", R.drawable.product_list_pazamas_img))
            add(Product("스프링샤인", "짜욱작가의 사막여우 티셔츠", "발달장애인 예술가 육성", R.drawable.product_list_fox_img))
            add(Product("목화송이협동조합", "20 BOTTLES 워킹백", "취약계층 여성 생필품 지원", R.drawable.product_list_20_img))
            add(Product("페어트레이드 코리아", "스퀘어 가디건 블랙", "공정무역", R.drawable.product_list_cardigan_img))
        }

        productData2.apply {
            add(Product("아시아공정무역네트워크", "페어데이 생캐슈넛(250g)", "공정무역", R.drawable.product_list_nuts_img))
            add(Product("마마나스협동조합", "오가닉 천 유아슈트", "비혼모 지원", R.drawable.product_list_kids_img))
            add(Product("트립티", "트립티 원두 티백", "공정무역", R.drawable.product_list_tee_img))
            add(Product("목화송이협동조합", "가벼운 방수앞치마", "취약계층 여성 생필품 지원", R.drawable.product_list_apron_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceProductRvAdapter1.setMyItemClickListener(this)
        priceFiveProductRv1.layoutManager = LinearLayoutManager(context)
        priceFiveProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceFiveProductRv2.layoutManager = LinearLayoutManager(context)
        priceFiveProductRv2.adapter = priceProductRvAdapter2

        return view
    }

    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity6::class.java)
        intent.putExtra("Product",Product)
        startActivity(intent)
    }
}
