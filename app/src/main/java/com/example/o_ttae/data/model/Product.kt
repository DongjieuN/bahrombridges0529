package com.example.o_ttae.data.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    var company: String? = "",
    var name: String? = "",
    var price: String? = "",
    var coverImg: Int? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(company)
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeValue(coverImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
