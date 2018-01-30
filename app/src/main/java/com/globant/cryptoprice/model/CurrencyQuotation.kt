package com.globant.cryptoprice.model

import android.os.Parcel
import android.os.Parcelable

class CurrencyQuotation() : Parcelable {
    var name = ""
    var price_usd = ""
    var percent_change_24h = ""
    var percent_change_7d = ""
    var percent_change_1h = ""
    var symbol = ""


    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        price_usd = parcel.readString()
        percent_change_24h = parcel.readString()
        percent_change_7d = parcel.readString()
        percent_change_1h = parcel.readString()
        symbol = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(price_usd)
        parcel.writeString(percent_change_24h)
        parcel.writeString(percent_change_7d)
        parcel.writeString(percent_change_1h)
        parcel.writeString(symbol)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrencyQuotation> {
        override fun createFromParcel(parcel: Parcel): CurrencyQuotation {
            return CurrencyQuotation(parcel)
        }

        override fun newArray(size: Int): Array<CurrencyQuotation?> {
            return arrayOfNulls(size)
        }
    }
}