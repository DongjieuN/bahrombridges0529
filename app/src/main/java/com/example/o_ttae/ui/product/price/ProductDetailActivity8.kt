package com.example.o_ttae.ui.product.price

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.o_ttae.R
import com.example.o_ttae.data.model.Product



class ProductDetailActivity8: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail8)

        // Get the data from the previous activity
        val Product = intent.getParcelableExtra<Product>("Product")
        // Use the data to populate the views in the product detail activity
        // ...
    }
}
