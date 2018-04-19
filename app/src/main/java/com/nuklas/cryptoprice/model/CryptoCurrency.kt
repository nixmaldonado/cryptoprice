package com.nuklas.cryptoprice.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "currencies")
class CryptoCurrency {

    @PrimaryKey
    @ColumnInfo(name = "name")
    var name = ""

    @ColumnInfo(name = "amount")
    var amount = ""
}