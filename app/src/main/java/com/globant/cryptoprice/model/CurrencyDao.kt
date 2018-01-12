package com.globant.cryptoprice.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM CryptoCurrency")
    fun getAll(): List<CryptoCurrency>

    @Insert
    fun insertAll(currency: CryptoCurrency)

}