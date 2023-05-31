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

class PriceOneFragment : Fragment() {

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
            add(Product("임페리얼1", "데니쉬버터쿠키셀렉션 500g(대용량)", "9,900", R.drawable.product_list_snack_img))
            add(Product("클럽클리오", "페리페라 잉크 더 에어리벨벳 물복딱복", "7,200", R.drawable.product_list_tint_img))
            add(Product("solful", "내열 이중유리컵 동물컵 글라스 280ml", "8,500", R.drawable.product_list_animal_cup_img))
            add(Product("EGOIDSM", "미니 빔프로젝터 무드 세트", "9,800", R.drawable.product_list_beam_img))
        }

        productData2.apply {
            add(Product("임페리얼2", "데니쉬버터쿠키셀렉션 500g(대용량)", "9,900", R.drawable.product_list_snack_img))
            add(Product("클럽클리오", "페리페라 잉크 더 에어리벨벳 물복딱복", "7,200", R.drawable.product_list_tint_img))
            add(Product("solful", "내열 이중유리컵 동물컵 글라스 280ml", "8,500", R.drawable.product_list_animal_cup_img))
            add(Product("EGOIDSM", "미니 빔프로젝터 무드 세트", "9,800", R.drawable.product_list_beam_img))
        }

        // Set up the adapter and layout manager for priceProductRv1
        val priceProductRvAdapter1 = ProductRVAdapter(productData1)
        priceOneProductRv1.layoutManager = LinearLayoutManager(context)
        priceOneProductRv1.adapter = priceProductRvAdapter1

        // Set up the adapter and layout manager for priceProductRv2
        val priceProductRvAdapter2 = ProductRVAdapter(productData2)
        priceOneProductRv2.layoutManager = LinearLayoutManager(context)
        priceOneProductRv2.adapter = priceProductRvAdapter2

        return view
    }
}

