package com.example.o_ttae.ui.login.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.o_ttae.R
import com.example.o_ttae.data.model.WeekProduct
import kotlinx.android.synthetic.main.activity_product_detail1.*


class ProductDetailActivity12 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail12)

        // Get the data from the previous activity
        val weekProduct = intent.getParcelableExtra<WeekProduct>("weekProduct")
        // Use the data to populate the views in the product detail activity
        // ...

        seller_image.setOnClickListener {
            val url = "https://www.sandeulsandeul.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }


}
