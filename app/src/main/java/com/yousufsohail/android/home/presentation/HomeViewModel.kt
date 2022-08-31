package com.yousufsohail.android.home.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yousufsohail.android.home.domain.model.NewsResults
import com.yousufsohail.android.home.domain.model.Stocks
import com.yousufsohail.android.home.domain.usecase.GetNewsUseCase
import com.yousufsohail.android.home.domain.usecase.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getStocksUseCase: GetStocksUseCase,
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {

    val TAG = HomeViewModel::class.java.simpleName

    val stocks: MutableState<List<Stocks>> = mutableStateOf(listOf())
    val news: MutableState<List<NewsResults.News>> = mutableStateOf(listOf())

    val loadingStocks = mutableStateOf(false)
    val loadingNews = mutableStateOf(false)

    private var stockPrices: List<Stocks> = emptyList()

    init {
        onTriggerEvent(HomeEvent.FetchEvent)
        subscribeToStockUpdate()
    }

    fun onTriggerEvent(event: HomeEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is HomeEvent.FetchEvent -> {
                        fetchStock(false)
                        fetchNews(false)
                    }
                    HomeEvent.RefreshFetchEvent -> {
                        fetchStock(true)
                        fetchNews(true)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            } finally {
                Log.d(TAG, "launchJob: finally called.")
            }
        }
    }

    private suspend fun fetchStock(forceRefresh: Boolean) {
        getStocksUseCase.execute(forceRefresh).onEach { dataState ->
            loadingStocks.value = dataState.loading
            dataState.data?.let { list ->
                stockPrices = list
                stocks.value = listOf()
                stocks.value = stockPrices.distinctBy { it.symbol }
            }
            dataState.error?.let { error ->
                stocks.value = listOf()
            }
        }.launchIn(viewModelScope)
    }

    private fun subscribeToStockUpdate() {
        viewModelScope.launch {
            while (viewModelScope.isActive) {
                delay(1000)
                stockPrices.shuffled()
                stocks.value = stockPrices.distinctBy { it.symbol }
            }
        }
    }

    private suspend fun fetchNews(forceRefresh: Boolean) {
        getNewsUseCase.execute(forceRefresh).onEach { dataState ->
            loadingNews.value = dataState.loading
            dataState.data?.let { list ->
                news.value = listOf()
                news.value = list
            }
            dataState.error?.let { error ->
                news.value = listOf()
            }
        }.launchIn(viewModelScope)
    }
}
