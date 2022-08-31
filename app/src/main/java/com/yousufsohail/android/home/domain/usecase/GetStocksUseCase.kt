package com.yousufsohail.android.home.domain.usecase

import com.yousufsohail.android.common.BaseUseCase
import com.yousufsohail.android.home.domain.DataState
import com.yousufsohail.android.home.domain.model.Stocks
import com.yousufsohail.android.home.repository.StocksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetStocksUseCase : BaseUseCase<Boolean, Flow<DataState<List<Stocks>>>>

class DefaultGetStocksUseCase @Inject constructor(private val stocksRepository: StocksRepository) : GetStocksUseCase {

    override suspend fun execute(input: Boolean): Flow<DataState<List<Stocks>>> = flow {
        try {
            emit(DataState.loading())
            emit(DataState.success(stocksRepository.getStocks()))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown error"))
        }
    }
}
