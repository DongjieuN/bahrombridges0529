package com.example.o_ttae.ui.product


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.o_ttae.R
import com.example.o_ttae.data.model.WeekProduct


class ProductDetailActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail1)

        // Get the data from the previous activity
        val weekProduct = intent.getParcelableExtra<WeekProduct>("weekProduct")
        // Use the data to populate the views in the product detail activity
        // ...
    }
}
