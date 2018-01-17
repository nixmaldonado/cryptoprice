package com.globant.cryptoprice.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currencies")
    fun getAll(): List<CryptoCurrency>

    @Insert
    fun insertAll(currency: CryptoCurrency)

    @Query("SELECT * FROM currencies WHERE name LIKE :arg0")
    fun getCurrency(name: String): List<CryptoCurrency>

    @Query("UPDATE currencies SET amount = :arg1 WHERE name = :arg0")
    fun updateCurrency(name: String, amount : String)

}