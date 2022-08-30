package com.yousufsohail.android.home.domain.usecase

import com.yousufsohail.android.common.BaseUseCase
import com.yousufsohail.android.home.domain.model.Stocks
import com.yousufsohail.android.home.repository.StocksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetStocksUseCase : BaseUseCase<Pair<Double, Double>, Flow<Stocks>>

class DefaultGetStocksUseCase @Inject constructor(private val stocksRepository: StocksRepository) : GetStocksUseCase {
    override suspend fun execute(input: Pair<Double, Double>): Flow<Stocks> {
        return flow {
            stocksRepository.getStocks()
        }
    }
}
