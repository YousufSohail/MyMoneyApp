package com.yousufsohail.android.home.cache.common.resources

import com.yousufsohail.android.common.resources.CSVParser
import com.yousufsohail.android.home.domain.model.Stocks
import java.io.InputStream

class FakeCSVParser : CSVParser<Stocks> {
    override suspend fun parse(stream: InputStream): List<Stocks> {
        return listOf(
            Stocks("123", "AAPL", 54.5),
            Stocks("123", "FORD", 34.5),
            Stocks("123", "NVDA", 24.5),
        )
    }
}
