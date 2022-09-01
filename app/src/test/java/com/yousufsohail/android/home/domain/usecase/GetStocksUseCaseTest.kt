package com.yousufsohail.android.home.domain.usecase

import com.yousufsohail.android.home.domain.model.Stocks
import com.yousufsohail.android.home.repository.FakeStocksRepository
import com.yousufsohail.android.home.repository.StocksRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetStocksUseCaseTest {

    // system in test
    private lateinit var getStocksUseCase: GetStocksUseCase

    //dependencies
    private lateinit var stocksRepository: StocksRepository


    @BeforeEach
    fun setup() {

        stocksRepository = FakeStocksRepository()

        getStocksUseCase = DefaultGetStocksUseCase(stocksRepository)
    }

    @Test
    fun getRepositoriesFromNetwork_emitRepositoriesFromCache(): Unit = runBlocking {

        val flowItems = getStocksUseCase.execute(false).toList()

        // first emission should be `loading`
        assert(flowItems[0].loading)

        // Second emission should be the list of repositories
        val stocks = flowItems[1].data
        assert(stocks?.size ?: 0 > 0)

        // confirm they are actually Repository objects
        assert(stocks?.get(index = 0) is Stocks)

        assert(!flowItems[1].loading) // loading should be false now
    }

    @AfterEach
    fun tearDown() {

    }
}
