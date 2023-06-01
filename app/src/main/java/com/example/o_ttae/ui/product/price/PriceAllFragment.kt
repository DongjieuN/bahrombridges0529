package com.example.o_ttae.ui.product.price

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

class PriceAllFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    private lateinit var priceProductRv1: RecyclerView
    private lateinit var priceProductRv2: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_price, container, false)

        priceProductRv1 = view.findViewById(R.id.price_product_rv1)
        priceProductRv2 = view.findViewById(R.id.price_product_rv2)

        productData1.apply {
            add(Product("소이프", "버키버킷햇", "32,000", R.drawable.product_list_hat_img))
            add(Product("산들산들", "산들산들 생리대", "4,900", R.drawable.product_list_sandle_img))
            add(Product("그라나다보호작업센터", "밸런스 브라운", "16,000", R.drawable.product_list_bean_img))
            add(Product("페어트레이드코리아", "스퀘어 가디건 블랙", "96,600", R.drawable.product_list_cardigan_img))
            add(Product("맘씨생활건강", "이공이공핸드워시", "5,000", R.drawable.product_list_handwash_img))
            add(Product("하이사이클", "커피자루 필통 케이스", "12,000", R.drawable.product_list_case_img))
        }

        productData2.apply {
            add(Product("스프링샤인", "짜욱작가의 사막여우 티셔츠", "23,000", R.drawable.product_list_fox_img))
            add(Product("두리하나다울", "쿠키선물바구니(중)", "50,000", R.drawable.product_list_cookie_img))
            add(Product("엘리트프랜즈", "친환경 행주", "10,000", R.drawable.product_list_dishcloth_img))
            add(Product("목화송이협동조합", "20 BOTTLES 워킹백", "12,000", R.drawable.product_list_20_img))
            add(Product("트립티", "트립티 원두 티백", "6,000", R.drawable.product_list_tee_img))
            add(Product("다올협동조합", "올바른 순면 파자마 바지 남성/여성/커플", "19,900", R.drawable.product_list_pazamas_img))
        }


        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceProductRvAdapter1.setMyItemClickListener(this)
        priceProductRv1.layoutManager = LinearLayoutManager(context)
        priceProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceProductRv2.layoutManager = LinearLayoutManager(context)
        priceProductRv2.adapter = priceProductRvAdapter2

        return view
    }
    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity5::class.java)
        intent.putExtra("Product",Product)
        startActivity(intent)
    }
}

