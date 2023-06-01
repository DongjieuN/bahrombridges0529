package com.example.o_ttae.data.model

import android.os.Parcel
import android.os.Parcelable

data class WeekProduct(
    var caption: String? = "",
    var name: String? = "",
    var coverImg: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(caption)
        parcel.writeString(name)
        parcel.writeValue(coverImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeekProduct> {
        override fun createFromParcel(parcel: Parcel): WeekProduct {
            return WeekProduct(parcel)
        }

        override fun newArray(size: Int): Array<WeekProduct?> {
            return arrayOfNulls(size)
        }
    }
}
