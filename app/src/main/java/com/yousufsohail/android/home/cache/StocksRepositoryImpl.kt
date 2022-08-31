package com.yousufsohail.android.home.cache

import android.content.Context
import com.yousufsohail.android.common.resources.CSVParser
import com.yousufsohail.android.home.domain.model.Stocks
import com.yousufsohail.android.home.repository.StocksRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StocksRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val stocksParser: CSVParser<Stocks>
) : StocksRepository {

    override suspend fun getStocks(): List<Stocks> {
        return stocksParser.parse(stream = context.assets.open("stocks.csv"))
    }
}

