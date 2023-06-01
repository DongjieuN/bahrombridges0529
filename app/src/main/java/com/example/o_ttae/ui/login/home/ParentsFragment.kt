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
import java.util.*

class ParentsFragment : Fragment(),ProductRVAdapter.MyItemClickListener {

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
            add(Product("산들산들", "산들산들 생리대", "4,900", R.drawable.product_list_sandle_img))
            add(Product("늘푸름보호작업장", "두루마리 휴지 50m", "6,050", R.drawable.product_list_tissue_img))
            add(Product("엘리트프랜즈", "친환경 행주 에코 아프로 4개입", "11,000", R.drawable.product_list_dishcloth_img))
            add(Product("오피스배재", "명장 불난로 손난로", "5,000", R.drawable.product_list_handwarmer_img))
        }

        productData2.apply {
            add(Product("오피스배재", "3D 정전기 밀대 청소기 리필", "2,500", R.drawable.product_list_plunger_img))
            add(Product("맘씨생활건강", "이공이공핸드워스", "5,000", R.drawable.product_list_handwash_img))
            add(Product("담쟁이", "아이엠 디퓨저", "15,000", R.drawable.product_list_defuser_img))
            add(Product("다함께", "휴대용 물티슈 10매 50세트", "42,500", R.drawable.product_list_wet_img))
        }

        // 어댑터와 데이터 리스트 연결
        val homeParentsProductRVAdapter1 = ProductRVAdapter(productData1)
        homeParentsProductRVAdapter1.setMyItemClickListener(this)
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

    override fun onItemClick(Product: Product) {
        val intent = Intent(requireContext(), ProductDetailActivity12::class.java)
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
