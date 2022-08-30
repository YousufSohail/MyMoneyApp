package com.yousufsohail.android.home.presentation

import androidx.lifecycle.ViewModel
import com.yousufsohail.android.home.domain.usecase.GetNewsUseCase
import com.yousufsohail.android.home.domain.usecase.GetStocksUseCase
import com.yousufsohail.android.home.domain.usecase.GetTrendingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getStocksUseCase: GetStocksUseCase,
    private val getTrendingNewsUseCase: GetTrendingNewsUseCase,
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {



}
