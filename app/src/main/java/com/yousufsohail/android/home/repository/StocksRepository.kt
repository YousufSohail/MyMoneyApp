package com.yousufsohail.android.home.repository

import com.yousufsohail.android.home.domain.model.Stocks

interface StocksRepository {
    suspend fun getStocks(): List<Stocks>
}
