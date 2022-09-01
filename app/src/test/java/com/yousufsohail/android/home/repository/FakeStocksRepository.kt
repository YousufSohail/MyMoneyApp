package com.yousufsohail.android.home.repository

import com.yousufsohail.android.home.domain.model.Stocks

class FakeStocksRepository() : StocksRepository {
    override suspend fun getStocks(): List<Stocks> {
        return listOf(
            Stocks("123", "AAPL", 54.5),
            Stocks("123", "FORD", 34.5),
            Stocks("123", "NVDA", 24.5),
        )
    }
}
