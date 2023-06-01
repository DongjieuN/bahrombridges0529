package com.example.o_ttae.ui.product


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.o_ttae.R
import com.example.o_ttae.data.model.WeekProduct
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.fragment_my.*


class ProductDetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val weekProduct = intent.getParcelableExtra<WeekProduct>("weekProduct")
        // Use the data to populate the views in the product detail activity

        seller_image.setOnClickListener {
            val url = "http://www.dongplus.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        // ...
    }
}
