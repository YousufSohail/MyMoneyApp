package com.yousufsohail.android.home.cache.util

import com.opencsv.CSVReader
import com.yousufsohail.android.common.resources.CSVParser
import com.yousufsohail.android.home.domain.model.Stocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockParser @Inject constructor() : CSVParser<Stocks> {
    override suspend fun parse(stream: InputStream): List<Stocks> {

        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line ->
                    val symbol = line.getOrNull(0)
                    Stocks(
                        symbol = symbol ?: return@mapNotNull null,
                        price = roundOffDecimal(line[1].toDouble())
                    )
                }
                .also {
                    csvReader.close()
                }
        }
    }
}
