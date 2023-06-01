package com.example.o_ttae.ui.product.price // 후원 및 기부

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

class PriceOneFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

    private var productData1 = ArrayList<Product>()
    private var productData2 = ArrayList<Product>()
    private lateinit var priceOneProductRv1: RecyclerView
    private lateinit var priceOneProductRv2: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_price, container, false)

        priceOneProductRv1 = view.findViewById(R.id.price_product_rv1)
        priceOneProductRv2 = view.findViewById(R.id.price_product_rv2)

        productData1.apply {
            add(Product("산들산들", "산들산들 생리대", "저소득청소년 생리대 후원", R.drawable.product_list_sandle_img))
            add(Product("소이프", "버키버킷햇", "보육시설 청소년 자립 도움", R.drawable.product_list_bucket_img))
            add(Product("담쟁이", "아이엠 디퓨저", "수익금 전액 발전기금 사용", R.drawable.product_list_defuser_img))
            add(Product("마인드디자인", "생각하는 구슬 여자용", "전통 문화 컨텐츠 재가공", R.drawable.product_list_biz_img))
        }

        productData2.apply {
            add(Product("동그라미 플러스", "맛있는 육포야", "장애인 직업 재활시설 운영 및 후원", R.drawable.product_list_yukpo_img))
            add(Product("그라나다보호작업센터", "밸런스브라운", "장애인 직업 재활시설 운영 및 후원", R.drawable.product_list_bean_img))
            add(Product("두리하나다울", "쿠키선물바구니(중)", "성인 중증발달장애인 자립 도움", R.drawable.product_list_cookie_img))
            add(Product("소이프", "홀마핸 티셔츠 화이트", "보육시설 청소년 자립 도움", R.drawable.product_list_white_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceProductRvAdapter1.setMyItemClickListener(this)
        priceOneProductRv1.layoutManager = LinearLayoutManager(context)
        priceOneProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceOneProductRv2.layoutManager = LinearLayoutManager(context)
        priceOneProductRv2.adapter = priceProductRvAdapter2

        return view
    }

    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity7::class.java)
        intent.putExtra("Product",Product)
        startActivity(intent)
    }
}

