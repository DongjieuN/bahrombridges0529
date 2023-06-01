package com.example.o_ttae.ui.product.price //일자리 창출

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

class PriceTwoFourFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

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
            add(Product("누리봄사회적협동조합", "도담잡곡누룽지", "중증장애인 일자리 제공", R.drawable.product_list_nulungzi_img))
            add(Product("비컴프렌즈", "Obong miel 꿀스틱", "발달장애인 일자리 제공", R.drawable.product_list_honey_img))
            add(Product("맘씨생활건강", "이공이공핸드워시", "취약계층 여성 일자리 제공", R.drawable.product_list_handwash_img))
            add(Product("신호에이피엘", "특양면 오버핏 맨투맨", "취약계층 여성,장애인 일자리 제공", R.drawable.product_list_green_img))
        }

        productData2.apply {
            add(Product("늘푸름보호작업장", "두루마리 휴지 50m", "중증장애인 일자리 제공", R.drawable.product_list_tissue_img))
            add(Product("엘리트프랜즈", "친환경 행주 에코 아프로 4개입", "친환경 & 취약계층 일자리 제공", R.drawable.product_list_dishcloth_img))
            add(Product("오피스배재", "명장 불난로 손난로", "소외계층 고용 촉진 활동", R.drawable.product_list_handwarmer_img))
            add(Product("다함께", "휴대용 물티슈 10매 50세트", "장애인 일자리 제공", R.drawable.product_list_wet_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceProductRvAdapter1.setMyItemClickListener(this)
        priceTwoFourProductRv1.layoutManager = LinearLayoutManager(context)
        priceTwoFourProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceTwoFourProductRv2.layoutManager = LinearLayoutManager(context)
        priceTwoFourProductRv2.adapter = priceProductRvAdapter2

        return view
    }
    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity8::class.java)
        intent.putExtra("Product",Product)
        startActivity(intent)
    }
}