package com.yousufsohail.android.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.yousufsohail.android.home.presentation.component.LoadingListShimmer
import com.yousufsohail.android.home.presentation.component.NewsSection
import com.yousufsohail.android.home.presentation.component.RetryView
import com.yousufsohail.android.home.presentation.component.StockTicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val stocks = viewModel.stocks.value
                val news = viewModel.news.value
                val loadingStocks = viewModel.loadingStocks.value
                val loadingNews = viewModel.loadingNews.value

                Box(modifier = Modifier.fillMaxSize()) {
                    if ((loadingStocks && stocks.isEmpty()) || (loadingNews && news.isEmpty())) {
                        LoadingListShimmer(imageHeight = 100.dp)
                    } else if (stocks.isEmpty() || news.isEmpty()) {
                        RetryView { viewModel.onTriggerEvent(HomeEvent.RefreshFetchEvent) }
                    } else {
                        SwipeRefresh(
                            state = rememberSwipeRefreshState(loadingStocks || loadingNews),
                            onRefresh = { viewModel.onTriggerEvent(HomeEvent.RefreshFetchEvent) },
                        ) {
                            Column {
                                StockTicker(stocks)
                                NewsSection(news.subList(0, 5), news.drop(6))
                            }
                        }
                    }
                }
            }
        }
    }
}
