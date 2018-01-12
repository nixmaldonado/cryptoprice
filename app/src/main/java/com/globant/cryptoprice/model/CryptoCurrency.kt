package com.globant.cryptoprice.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(primaryKeys = ["name"])
class CryptoCurrency {

    @PrimaryKey
    var name = ""
    var amount = ""
}